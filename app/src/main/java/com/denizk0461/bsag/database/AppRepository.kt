package com.denizk0461.bsag.database

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import androidx.preference.PreferenceManager
import com.denizk0461.bsag.exception.LinesNotDownloadedException
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.model.LineWithDiversions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.jvm.Throws

class AppRepository(application: Application) {

    // Reference to the database access object used to handle database transactions
    private val dao: AppDAO = AppDatabase.getInstance(application.applicationContext).dao()

    // Shared preferences used to store small values
    private val prefs = PreferenceManager.getDefaultSharedPreferences(application)

    // Fetcher object for web contents
    private val webFetcher = WebFetcher()

    // Static context for maintaining a singleton instance of the repository
    companion object {

        /**
         * Reference to the app's repository. It is only instantiated once because it can only be
         * accessed by [getRepositoryInstance].
         */
        private lateinit var staticRepositoryInstance: AppRepository

        /**
         * Get a static instance of the repository. If none has been instantiated, one will be
         * created and saved into [staticRepositoryInstance].
         *
         * @return  static instance of the repository
         */
        fun getRepositoryInstance(app: Application): AppRepository {
            if (!::staticRepositoryInstance.isInitialized) {
                synchronized(Object::class.java) {
                    staticRepositoryInstance = AppRepository(app)
                }
            }
            return staticRepositoryInstance
        }
    }

    /**
     * Retrieves the diversion data from the web and stores it in the database. Preserves which
     * diversions the user has already read.
     *
     * @throws LinesNotDownloadedException  if there is an error with attaching diversions to lines
     */
    @Throws(LinesNotDownloadedException::class)
    suspend fun fetch(onFinish: () -> Unit) {

        // Check if any lines are stored
        if (dao.getLineCount() == 0) {
            /*
             * If there aren't any lines stored, throw a certain exception telling the user that
             * they must download lines before they can download diversions
             */
            throw LinesNotDownloadedException(certain = true)
        }

        // Fetch new data
        val fetchedData = webFetcher.fetch()

        // Retrieve the already stored data to get the read statuses of the elements therein
        val storedData = dao.getDiversions()

        // Check if any diversions are already stored in the database
        if (storedData.isNotEmpty()) {

            // Iterate through all objects in the newly retrieved data
            for (index in fetchedData.indices) {

                // Check if this diversion has already been downloaded before
                storedData.find { stored -> fetchedData[index].matches(stored) }
                    ?.let { storedElement ->

                        // Preserve the read status of the diversion
                        fetchedData[index].read = storedElement.read
                    }
            }

            // Delete all previous entries
            dao.nukeDiversions()
        }

        try {
            // Store the new data
            dao.insert(fetchedData)
        } catch (e: SQLiteConstraintException) {
            // If diversions cannot be assigned to lines, throw an uncertain exception
            throw LinesNotDownloadedException(certain = false)
        }

        withContext(Dispatchers.Main) {
            onFinish()
        }
    }

    fun getLines(): LiveData<List<Line>> = dao.getLines()

    fun getLinesWithDiversions(): LiveData<List<LineWithDiversions>> = dao.getLinesWithDiversions()
}
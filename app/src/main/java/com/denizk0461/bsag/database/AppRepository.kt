package com.denizk0461.bsag.database

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.preference.PreferenceManager
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.model.LineWithDiversions

class AppRepository(application: Application) {

    // Reference to the database access object used to handle database transactions
    private val dao: AppDAO = AppDatabase.getInstance(application.applicationContext).dao()

    // Shared preferences used to store small values
    private val prefs = PreferenceManager.getDefaultSharedPreferences(application)

    // Fetcher object for web contents
    private val webFetcher = WebFetcher()

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

    fun fetch() {
        dao.nukeDiversions()
        dao.insert(webFetcher.fetch())
    }

    fun getLines(): LiveData<List<Line>> = dao.getLines()

    fun getLinesWithDiversions(): LiveData<List<LineWithDiversions>> = dao.getLinesWithDiversions()

//    fun refreshDiversions() {
//        dao.updateDiversions(webFetcher.fetch())
//    }
}
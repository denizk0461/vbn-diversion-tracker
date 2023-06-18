package com.denizk0461.bsag.db

import android.app.Application
import androidx.preference.PreferenceManager

class AppRepository(application: Application) {

    // Reference to the database access object used to handle database transactions
    private val dao: AppDAO = AppDatabase.getInstance(application.applicationContext).dao()

    // Shared preferences used to store small values
    private val prefs = PreferenceManager.getDefaultSharedPreferences(application)

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
}
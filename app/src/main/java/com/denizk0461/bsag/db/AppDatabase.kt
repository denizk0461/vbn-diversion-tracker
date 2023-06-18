package com.denizk0461.bsag.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.denizk0461.bsag.model.Line

@Database(
    entities = [
        Line::class,
    ],
    version = 1,
    exportSchema = true,
    autoMigrations = [
    ],
)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Database access object. Database transactions go through this.
     */
    abstract fun dao(): AppDAO

    companion object {
        // The singular instance of this database
        private var instance: AppDatabase? = null

        /**
         * Retrieve the instance of the database.
         *
         * @param context   used to resolve the object
         * @return          the database
         */
        fun getInstance(context: Context): AppDatabase {
            /*
             * Check if an object has already been instantiated. Only create a new instance if none
             * exists.
             */
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "bsag_db",
                        )
                        .build()
                }
            }
            // Instance can never be null at this point
            return instance!!
        }
    }
}
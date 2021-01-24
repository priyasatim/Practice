package com.example.practice.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SignupRequest::class],version = 1,exportSchema = true)
abstract class SignUpDatabase : RoomDatabase() {

    abstract fun dao(): SignUpDao

    companion object {
        @Volatile
        var INSTANCE: SignUpDatabase? = null

        fun getDatabase(context: Context): SignUpDatabase {
            var tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SignUpDatabase::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}

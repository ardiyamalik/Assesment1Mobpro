package org.d3if4505.assesment1mobpro.ui.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Assesment2Entity::class], version = 1, exportSchema = false)
abstract class Assesment2Db : RoomDatabase() {


    abstract val dao: Assesment2Dao

    companion object {

        @Volatile
        private var INSTANCE: Assesment2Db? = null

        fun getInstance(context: Context): Assesment2Db {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Assesment2Db::class.java,
                        "assesment2"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
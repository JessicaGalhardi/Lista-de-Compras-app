package com.example.tp1_ads_desenvolvimentokotlim

import android.content.Context
import android.content.Entity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities =arrayOf(Lista::class), version = 1, exportSchema = false)

abstract class ListaComprasRoomDatabase : RoomDatabase() {

    abstract fun listaDao(): ListaDao

    private class ListaDatabaseCallback(

        private val scope: CoroutineScope

    ) : RoomDatabase.Callback() {


        override fun onCreate(db: SupportSQLiteDatabase) {

            super.onCreate(db)
            Instance?.let { database ->
                scope.launch {


                    val listaDao = database.listaDao()


                    val produto = Lista("TODO!")
                    listaDao.insert(produto)


                }


            }
        }
    }


        companion object {

            @Volatile
            private var Instance: ListaComprasRoomDatabase? = null

            fun getDatabase(
                context: Context
            ): ListaComprasRoomDatabase {

                return Instance ?: synchronized(this) {

                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ListaComprasRoomDatabase::class.java,
                        "word_database"
                    )
                        .build()
                    Instance = instance

                    instance
                }
            }
        }
    }













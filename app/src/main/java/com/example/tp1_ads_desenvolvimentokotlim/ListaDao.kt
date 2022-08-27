package com.example.tp1_ads_desenvolvimentokotlim

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ListaDao {

    @Query("SELECT * FROM word_table ORDER BY produto ASC")
    fun ordemAlfabetica(): Flow<List<Lista>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(produto: Lista)

}

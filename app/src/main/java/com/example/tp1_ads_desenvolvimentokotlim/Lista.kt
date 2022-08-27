package com.example.tp1_ads_desenvolvimentokotlim

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
(tableName = "word_table")
data class Lista(
    @PrimaryKey @ColumnInfo
    val produto: String)
package com.entersekt.shopsdk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shops")
data class Shop(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    val name: String
)

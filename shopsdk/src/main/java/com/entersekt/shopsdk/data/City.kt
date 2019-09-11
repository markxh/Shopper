package com.entersekt.shopsdk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class City(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    val name: String,
    val malls: List<Mall>
)
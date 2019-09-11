package com.entersekt.shopsdk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "malls")
data class Mall (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    val name: String,
    val shops: List<Shop>
)

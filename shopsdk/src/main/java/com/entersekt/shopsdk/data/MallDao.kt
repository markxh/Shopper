package com.entersekt.shopsdk.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MallDao {
    @Query("SELECT * FROM malls WHERE id = :cityId ORDER BY name")
    fun getMallsForCity(cityId: Int): LiveData<List<Mall>>

    @Query("SELECT * FROM malls WHERE id = :mallId")
    fun getMall(mallId: Int): LiveData<Mall>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(malls: List<Mall>)
}
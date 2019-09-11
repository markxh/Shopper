package com.entersekt.shopsdk.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CityDao {
    @Query("SELECT * FROM cities")
    fun getAllCities(): LiveData<List<City>>

    @Query("SELECT * FROM cities WHERE id = :cityId")
    fun getCity(cityId: Int): LiveData<City>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cities: List<City>)
}
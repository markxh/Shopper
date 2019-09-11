package com.entersekt.shopsdk.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShopDao {
    @Query("SELECT * FROM shops WHERE id = :mallId ORDER BY name")
    fun getShopsForMall(mallId: Int): LiveData<List<Shop>>

    @Query("SELECT * FROM shops WHERE id = :shopId")
    fun getShop(shopId: Int): LiveData<Shop>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(shops: List<Shop>)
}
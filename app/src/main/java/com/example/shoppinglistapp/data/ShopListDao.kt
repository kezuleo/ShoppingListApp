package com.example.shoppinglistapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShopListDao {

    @Query("SELECT * FROM shopitems")
    fun getShopList(): LiveData<List<ShopItemDBModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShopItem(shopItemDBModel: ShopItemDBModel)

    @Query("DELETE FROM shopitems WHERE id =:shopItemId")
    fun deleteShopItem(shopItemId: Int)

    @Query("SELECT * FROM shopitems WHERE id=:shopItemId LIMIT 1")
    fun getShopItem(shopItemId: Int): ShopItemDBModel
}
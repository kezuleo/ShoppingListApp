package com.example.shoppinglistapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ShopItems")
data class ShopItemDBModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)

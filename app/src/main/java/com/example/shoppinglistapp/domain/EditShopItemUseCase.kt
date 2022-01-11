package com.example.shoppinglistapp.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItemUseCase(shopItem: ShopItem) {
        shopListRepository.editShopItemUseCase(shopItem)
    }
}
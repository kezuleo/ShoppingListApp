package com.example.shoppinglistapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.domain.ShopItem
import androidx.recyclerview.widget.ListAdapter as ListAdapter1

class ShopListAdapter : ListAdapter1<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            ENABLED_VIEW_TYPE -> R.layout.item_shop_enabled
            DISABLED_VIEW_TYPE -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown ViewType: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        val shopItem = getItem(position)
        return if (shopItem.enabled) {
            ENABLED_VIEW_TYPE
        } else {
            DISABLED_VIEW_TYPE
        }
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        viewHolder.itemView.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        viewHolder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.count.toString()
    }

    companion object {
        const val ENABLED_VIEW_TYPE = 1
        const val DISABLED_VIEW_TYPE = 0

        const val MAX_POOL_SIZE = 15
    }

}
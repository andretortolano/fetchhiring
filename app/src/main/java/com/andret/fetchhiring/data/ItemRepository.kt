package com.andret.fetchhiring.data

import com.andret.fetchhiring.domain.Item
import com.andret.fetchhiring.domain.ItemProvider

class ItemRepository: ItemProvider {

    override suspend fun getItems(): List<Item> {
        return listOf(
            Item(1, 1, "Item 1"),
            Item(2, 1, "Item 2"),
            Item(3, 2, "Item 3"),
            Item(4, 2, "Item 4"),
        )
    }
}
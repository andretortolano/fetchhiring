package com.andret.fetchhiring.data

import com.andret.fetchhiring.domain.ItemEntity
import com.andret.fetchhiring.domain.ItemProvider

class ItemRepository(
    private val itemRemoteSource: ItemRemoteSource
) : ItemProvider {

    override suspend fun getItems(): List<ItemEntity> {
        // right now this does not do much but in the future we might want to cache
        // response and prefetch while getting new list from the web or have support
        // for offline mode.
        // TODO: handle possible exception from remote source
        return itemRemoteSource.getItems()
            .toItems()
    }

    private fun List<ItemDTO>.toItems(): List<ItemEntity> {
        return map { ItemEntity(it.id, it.listId, requireNotNull(it.name)) }
    }
}

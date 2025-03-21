package com.andret.fetchhiring.data.remote

import com.andret.fetchhiring.data.ItemDTO
import com.andret.fetchhiring.data.ItemRemoteSource

class RetrofitItemSource(private val retrofitItemService: RetrofitItemService) : ItemRemoteSource {

    override suspend fun getItems(): List<ItemDTO> {
        // idea here is to request data from outside and make sure we discard whats not
        // interesting to our application
        return retrofitItemService.getItems()
            .toItemsDTO()
    }

    private fun List<ItemResponse>.toItemsDTO(): List<ItemDTO> {
        return mapNotNull {
            // handle data from outside world, excluding where name is null or empty
            if (it.name.isNullOrEmpty()) return@mapNotNull null
            // return Data Transfer Object
            ItemDTO(it.id, it.listId, it.name)
        }
    }
}

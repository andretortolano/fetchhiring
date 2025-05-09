package com.andret.fetchhiring.domain

class GetSortedItemsListUseCase(private val itemProvider: ItemProvider) {

    suspend fun invoke(): List<ItemListEntity> {
        return itemProvider.getItems()
            // Group By listId
            .groupBy { it.listId }
            // Sort By name
            .mapValues { (_, items) -> items.sortedBy { it.name } }
            // Map to ItemList
            .map { (listId, items) -> ItemListEntity(listId, items) }
            // Sort List by listId
            .sortedBy { it.id }
    }
}
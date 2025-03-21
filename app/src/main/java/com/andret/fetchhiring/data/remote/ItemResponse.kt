package com.andret.fetchhiring.data.remote

data class ItemResponse(
    val id: Int,
    val listId: Int,
    val name: String? // this is possible null from the response
)
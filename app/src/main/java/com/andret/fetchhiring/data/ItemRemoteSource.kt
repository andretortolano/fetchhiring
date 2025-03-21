package com.andret.fetchhiring.data

interface ItemRemoteSource {

    suspend fun getItems(): List<ItemDTO>
}
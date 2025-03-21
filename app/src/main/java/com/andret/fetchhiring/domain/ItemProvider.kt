package com.andret.fetchhiring.domain

interface ItemProvider {
    suspend fun getItems(): List<ItemEntity>
}
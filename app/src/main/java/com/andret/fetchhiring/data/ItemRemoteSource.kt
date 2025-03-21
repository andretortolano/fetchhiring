package com.andret.fetchhiring.data

import retrofit2.http.GET

internal interface ItemRemoteSource {

    // https://fetch-hiring.s3.amazonaws.com/
    @GET("hiring.json")
    suspend fun getItems(): List<ItemResponse>
}
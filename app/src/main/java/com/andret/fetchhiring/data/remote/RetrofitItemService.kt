package com.andret.fetchhiring.data.remote

import retrofit2.http.GET

interface RetrofitItemService {

    @GET("hiring.json")
    suspend fun getItems(): List<ItemResponse>
}

package com.andret.fetchhiring.data.wrapper

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object S3RetrofitWrapper {

    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    private val okHttp = OkHttpClient.Builder().build()

    private val gson = GsonBuilder().create()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}
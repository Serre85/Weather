package com.hslee.data.api

import com.hslee.domain.model.Weathers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("data/2.5/forecast?")
    suspend fun weather(
        @Query("q") q: String,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Response<Weathers.RS>
}
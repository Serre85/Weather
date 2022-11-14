package com.hslee.data.repository

import android.content.Context
import com.hslee.data.api.ApiService
import com.hslee.domain.model.Weathers
import com.hslee.domain.repository.WeathersRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
import javax.inject.Inject

class WeathersRepositoryImpl @Inject constructor(
    @ApplicationContext
    val applicationContext: Context,
    private val api: ApiService
) : WeathersRepository {
    override suspend fun weather(rq: Weathers.RQ): Response<Weathers.RS> {
        return api.weather(rq.q, rq.metric, rq.appid)
    }
}
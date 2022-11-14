package com.hslee.domain.repository

import com.hslee.domain.model.Weathers
import retrofit2.Response

interface WeathersRepository {
    suspend fun weather(rq: Weathers.RQ): Response<Weathers.RS>
}
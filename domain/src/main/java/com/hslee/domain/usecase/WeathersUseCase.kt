package com.hslee.domain.usecase

import com.hslee.domain.model.Weathers
import com.hslee.domain.repository.WeathersRepository
import retrofit2.Response
import javax.inject.Inject

class WeathersUseCase @Inject constructor(private val repository: WeathersRepository) {
    suspend fun weather(rq: Weathers.RQ): Response<Weathers.RS> {
        return repository.weather(rq)
    }
}
package com.multimodulesample.domain

import com.multimodulesample.data.DataStoreRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository

) {
    fun getUserOnBoarded(): Boolean {
        return dataStoreRepository.getOnBoardingState()
    }
}
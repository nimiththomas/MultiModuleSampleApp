package com.multimodulesample.network.data

import com.multimodulesample.network.models.DetailsResponse
import com.multimodulesample.network.models.Result
import com.picker.core.network.di.restservice.ApiService
import com.picker.core.network.di.utils.networkBoundOperation
import javax.inject.Inject

class MultiModuleSampleDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getDetails(
        id: String,
    ): Result<DetailsResponse?> {
        return networkBoundOperation {
            apiService.getDetails(id)
        }
    }

}
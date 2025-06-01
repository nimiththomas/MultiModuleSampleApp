package com.multimodulesample.data.data

import com.multimodulesample.data.Feature2Repository
import com.multimodulesample.network.data.MultiModuleSampleDataSource
import com.multimodulesample.network.models.DetailsResponse
import com.multimodulesample.network.models.Result
import javax.inject.Inject

class Feature2RepositoryImpl @Inject constructor(
    private val multiModuleSampleRetrofitService: MultiModuleSampleDataSource
) : Feature2Repository {
    override suspend fun getDetails(id: String): Result<DetailsResponse?> {
        return multiModuleSampleRetrofitService.getDetails(id)
    }

}
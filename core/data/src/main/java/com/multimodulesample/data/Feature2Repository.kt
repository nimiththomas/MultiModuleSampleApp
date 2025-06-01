package com.multimodulesample.data

import com.multimodulesample.network.models.DetailsResponse
import com.multimodulesample.network.models.Result

interface Feature2Repository {
    suspend fun getDetails(id: String): Result<DetailsResponse?>
}
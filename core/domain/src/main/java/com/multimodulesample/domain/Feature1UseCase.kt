package com.multimodulesample.domain

import com.multimodulesample.data.Feature1Repository
import javax.inject.Inject

class Feature1UseCase @Inject constructor(
    private val feature1Repository: Feature1Repository

) {

    suspend fun getDetails(id: String) = feature1Repository.getDetails(id)
}
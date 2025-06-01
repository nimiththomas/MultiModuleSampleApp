package com.multimodulesample.domain

import com.multimodulesample.data.Feature2Repository
import javax.inject.Inject

class Feature2UseCase @Inject constructor(
    private val feature2Repository: Feature2Repository
) {

    suspend fun getDetails(id: String) = feature2Repository.getDetails(id)

}
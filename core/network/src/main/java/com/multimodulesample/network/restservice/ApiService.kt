package com.picker.core.network.di.restservice

import com.multimodulesample.network.models.DetailsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //These are dummy apis which do not exist . Just examples
    @GET("/upload/documents")
    suspend fun getDetails(
        @Query("documentId") documentId: String,
    ): DetailsResponse?


}
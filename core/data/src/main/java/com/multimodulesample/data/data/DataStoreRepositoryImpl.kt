package com.multimodulesample.data.data

import com.multimodulesample.data.DataStoreRepository
import com.multimodulesample.datastore.MultiModuleSampleDataStore
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val multiModuleSampleDataStore: MultiModuleSampleDataStore
) : DataStoreRepository {

    override fun getOnBoardingState(): Boolean = multiModuleSampleDataStore.isUserOnBoarded

    override fun setOnBoardingState(completed: Boolean) {
        multiModuleSampleDataStore.isUserOnBoarded = completed
    }

}
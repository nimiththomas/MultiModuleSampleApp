package com.multimodulesample.data

interface DataStoreRepository {
    fun getOnBoardingState(): Boolean
    fun setOnBoardingState(completed: Boolean)
}
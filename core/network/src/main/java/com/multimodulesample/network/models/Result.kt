package com.multimodulesample.network.models

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Failure(val exception: NetworkException) : Result<Nothing>()
}
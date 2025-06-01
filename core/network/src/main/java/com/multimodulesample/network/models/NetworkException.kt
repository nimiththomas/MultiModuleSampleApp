package com.multimodulesample.network.models

sealed class NetworkException {
    data class ServerError(val code: Int, val message: String?) : NetworkException()
    data class UnprocessableEntityError(val message: String?) : NetworkException()
    data object NoInternetError : NetworkException()
    data class NetworkError(val cause: Throwable) : NetworkException()
    data object UnknownError : NetworkException()
    data object UnAuthorisedError : NetworkException()

}
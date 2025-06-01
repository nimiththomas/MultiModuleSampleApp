package com.picker.core.network.di.utils

import com.multimodulesample.network.models.NetworkException
import com.multimodulesample.network.models.Result
import retrofit2.HttpException
import java.net.SocketTimeoutException


suspend fun <T> networkBoundOperation(
    call: suspend () -> T
): Result<T> {
    return try {
        Result.Success(call.invoke())
    } catch (exception: Exception) {
        when (exception) {
            is SocketTimeoutException -> {
                Result.Failure(
                    NetworkException.NoInternetError
                )
            }

            is HttpException -> {
                when (exception.code()) {
                    401 -> {
                        Result.Failure(
                            NetworkException.UnAuthorisedError
                        )
                    }

                    422 -> {
                        Result.Failure(
                            NetworkException.UnprocessableEntityError(convertErrorBody(exception))
                        )
                    }

                    else -> {
                        Result.Failure(
                            NetworkException.NetworkError(exception)
                        )
                    }
                }
            }

            else -> {
                Result.Failure(
                    NetworkException.NetworkError(exception)
                )
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): String {
    return try {
        throwable.response()?.errorBody()?.string() ?: ""
    } catch (exception: Exception) {
        ""
    }
}
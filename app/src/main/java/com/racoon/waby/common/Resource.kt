package com.racoon.waby.common

import java.lang.Exception

sealed class Resource<out T> {

    class Loading<out T> : Resource<T>()
    data class Result<out T>(val data: T) : Resource<T>()
    data class Failure<out T>(val exception: Exception) : Resource<T>()
}
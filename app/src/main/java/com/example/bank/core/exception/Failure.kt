package com.example.bank.core.exception

sealed class Failure {
    data class CustomError(val errorCode: Int, val errorMessage: String?) : Failure()
}
package com.example.base.http

interface ExceptionHandler {
    fun respondWithSomethingWentWrongException(message: String = "Something went wrong"): Exception

}
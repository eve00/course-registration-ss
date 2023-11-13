package com.example.base.http

class ExceptionHandlerImpl:ExceptionHandler {
    override fun respondWithSomethingWentWrongException(message: String): Exception {
        return SomethingWentWrongException(message)
    }
}

class SomethingWentWrongException(message: String?) : RuntimeException(message)

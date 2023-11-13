package com.example.di

import com.example.base.http.ExceptionHandler
import com.example.base.http.ExceptionHandlerImpl

object ConfigLocator {

    fun provideExceptionHandler(): ExceptionHandler {
        return ExceptionHandlerImpl()
    }
}
package com.example.di.database

import com.example.base.database.Database
import com.example.base.database.DatabaseImpl

object DatabaseLocator {
    private fun provideClientName(): String {
        return "demoDB"
    }

    fun provideDatabase(): Database {
        return DatabaseImpl(provideClientName(), APPLICATIONS_COLLECTION)
    }

    private val APPLICATIONS_COLLECTION = "applications"
}
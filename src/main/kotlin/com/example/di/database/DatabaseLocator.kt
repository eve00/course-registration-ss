package com.example.di.database

import com.example.plugins.database.Database
import com.example.plugins.database.DatabaseImpl

object DatabaseLocator {
    private fun provideClientName(): String {
        return "demoDB"
    }

    fun provideDatabase(): Database {
        return DatabaseImpl(provideClientName())
    }
}
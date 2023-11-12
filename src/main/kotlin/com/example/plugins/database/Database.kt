package com.example.plugins.database

import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineDatabase

interface Database {
    val initializeName: String

    val mongoClient: CoroutineClient

    val database: CoroutineDatabase
}
package com.example.base.database

import com.example.feature.apply.Application
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase

interface Database {
    val initializeName: String

    val mongoClient: CoroutineClient

    val database: CoroutineDatabase

    val applicationColelction: CoroutineCollection<Application>

}
package com.example.base.database

import com.example.feature.apply.Application
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class DatabaseImpl(private val clientName: String) : Database {
    override val initializeName: String
        get() = clientName
    override val mongoClient: CoroutineClient
        get() = KMongo.createClient().coroutine

    override val database: CoroutineDatabase
        get() = mongoClient.getDatabase(initializeName)
    override val applicationColelction: CoroutineCollection<Application>
        get() = database.getCollection()

}
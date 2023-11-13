package com.example.base.database

import CONNECTION_STRING_URI_PLACEHOLDER
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document


class DatabaseImpl(private val clientName: String, private val collectionName: String) : Database {
    override val uri: String
        get() =CONNECTION_STRING_URI_PLACEHOLDER
    override val initializeName: String
        get() = clientName

    override val clientSettings: MongoClientSettings
        get() = MongoClientSettings.builder()
            .applyConnectionString(ConnectionString("mongodb://localhost:27017"))
            .build()

    override val mongoClient: MongoClient
        get() = MongoClients.create(clientSettings)

    override val database: MongoDatabase
        get() = mongoClient.getDatabase(initializeName)
    override val applicationColelction: MongoCollection<Document>
        get() = database.getCollection(collectionName)
}
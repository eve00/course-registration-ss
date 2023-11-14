package com.example.base.database

import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document

interface Database {
    val uri: String
    val initializeName: String
    val clientSettings: MongoClientSettings
    val mongoClient: MongoClient

    val database: MongoDatabase

    val applicationColelction: MongoCollection<Document>
    val courseCollection: MongoCollection<Document>

}
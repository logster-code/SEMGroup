package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Main
{
    public static void main(String[] args)
    {
        // Connect to MongoDB
        MongoClient mongoClient = new MongoClient("mongo-dbserver");
        // Get a database - will create when we use it
        MongoDatabase database = mongoClient.getDatabase("mydb");
        // Get a collection from the database
        MongoCollection<Document> collection = database.getCollection("test");

        // Create a document to store
        Document doc = new Document("name", "bean")
                .append("class", "his own")
                .append("year", "classified")
                .append("result", new Document("CW", 95).append("EX", 85));
        // Add document to collection
        collection.insertOne(doc);
        System.out.println("Inserted: " + doc.toJson());
    }
}
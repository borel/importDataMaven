package com.importdata;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class Database {

	private DB db = null;
	private DBCollection collectionMessage;
	
	/**
	 * Init the database information with information stock in class Ressources
	 * @throws UnknownHostException
	 */
	public void connection() throws UnknownHostException {

		Mongo mongo;

		// connect to mongoDB, ip and port number
		mongo = new Mongo(PropertyLoader.getValue("database.host"),Integer.valueOf(PropertyLoader.getValue("database.port")));

		// get database from MongoDB,
		// if database doesn't exists, mongoDB will create it automatically
		db = mongo.getDB(PropertyLoader.getValue("database.name"));

		// take the collection from the database
		collectionMessage = db.getCollection(PropertyLoader.getValue("database.collection"));

	}
	
	/**
	 * Insert a message in database
	 * @param messageData
	 */
	public void insertMessage(MessageData messageData) {
		// insertion of the message
		BasicDBObject document = messageData.toBasicDBObject();

		// save it into collection
		collectionMessage.insert(document);
	}

}

package com.pruebas.gestorfranquicias.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.pruebas.gestorfranquicias.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "db-gestor-franquicias";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://mongodb:27017");
    }

    protected String getMappingBasePackage() {
        return "com.pruebas.gestorfranquicias";
    }
}


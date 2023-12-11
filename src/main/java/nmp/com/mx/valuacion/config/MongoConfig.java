package nmp.com.mx.valuacion.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Clase para manejar la conexión de mongo
 * */
@Configuration
public class MongoConfig {

    /**
     * Variable que contiene la uri de mongo
     * */
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    /**
     * Bean para crear la conexión a mongoDB
     * */
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    /**
     * Bean para seleccionar la base de datos de mongo
     * */
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "valuacion");
    }
}


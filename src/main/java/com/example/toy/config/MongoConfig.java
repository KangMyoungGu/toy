package com.example.toy.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    /*
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongodExecutable mongodExecutable = null;
        MongoTemplate mongoTemplate = null;
        String ip  = "127.0.0.1";
        int port  = 27017;

        ImmutableMongodConfig mongodConfig = MongodConfig.builder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(ip, port, Network.localhostIsIPv6()))
                .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        MongodProcess mongod = mongodExecutable.start();

        MongoClient mongo = MongoClients.create("mongodb://" + ip + ":" + port);

        mongoTemplate = new MongoTemplate(mongo, "local");
        mongoTemplate.dropCollection("TBL_INQUIRY");
        mongoTemplate.dropCollection("TBL_ANSWER");
        mongoTemplate.dropCollection("TBL_USER");

        mongoTemplate.createCollection("TBL_INQUIRY");
        mongoTemplate.createCollection("TBL_ANSWER");
        mongoTemplate.createCollection("TBL_USER");

        return mongoTemplate;
    }
    */
}


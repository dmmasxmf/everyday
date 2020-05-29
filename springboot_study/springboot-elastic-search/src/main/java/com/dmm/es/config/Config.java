//package com.dmm.es.config;
//
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
//import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
//import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
//
///**
// * @author Mr. Du
// * @explain
// * @createTime 2020/5/12 15:42
// * @motto The more learn, the more found his ignorance.
// */
//@Configuration
//public  class Config {
//
//    @Bean
//    RestHighLevelClient client(){
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("192.168.7.243:9200")
//                .build();
//
//        return RestClients.create(clientConfiguration).rest();
//    }
//}
//

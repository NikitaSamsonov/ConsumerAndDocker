package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "myserver.public.todo",
            groupId = "nodejs-consumer" ,containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) throws JsonProcessingException {

        var jsonObject = new JsonParser().parse(message).getAsJsonObject();
        var g = jsonObject.getAsJsonObject("payload");
        var x = g.get("after");

//        Gson gson = new GsonBuilder().create();
//        MessageDto r = gson.fromJson(message, MessageDto.class);
//        System.out.println(g);
//        Gson g = new Gson();
//        message =g.toJson();
        System.out.println(x);
       log.info(message.toString());
    }
}

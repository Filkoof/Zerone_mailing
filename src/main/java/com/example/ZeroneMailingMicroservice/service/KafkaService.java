/*
package com.example.ZeroneMailingMicroservice.service;

import com.example.ZeroneMailingMicroservice.dto.kafka.KafkaZeroneMailingDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<Long, KafkaZeroneMailingDto> kafkaZeroneMailingTemplate;
    private final ObjectMapper objectMapper;

    public void send(KafkaZeroneMailingDto dto) {
        kafkaZeroneMailingTemplate.send("zeroneMailingTopic-1", dto);
    }

    @KafkaListener(id = "zeroneMailConsumer", topics = {"zeroneMailingTopic-1"}, containerFactory = "consumerFactory")
    public void consume(KafkaZeroneMailingDto dto) {
        log.info("=> consumed {}", writeValueAsString(dto));
    }

    private String writeValueAsString(KafkaZeroneMailingDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}*/

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

    public void sendRepeat(KafkaZeroneMailingDto dto) {
        kafkaZeroneMailingTemplate.send("zeroneMailingRepeat-2", dto);
    }


}

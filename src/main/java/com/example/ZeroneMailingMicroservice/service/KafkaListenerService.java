package com.example.ZeroneMailingMicroservice.service;

import com.example.ZeroneMailingMicroservice.dto.kafka.KafkaZeroneMailingDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaListenerService {

    @KafkaListener(topics = "zeroneMailingTopic-1")
    void listener(KafkaZeroneMailingDto data) {
        log.info(data.toString());
    }

}

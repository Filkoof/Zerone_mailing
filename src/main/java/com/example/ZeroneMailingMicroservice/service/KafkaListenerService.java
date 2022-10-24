package com.example.ZeroneMailingMicroservice.service;

import com.example.ZeroneMailingMicroservice.dto.kafka.KafkaZeroneMailingDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaListenerService {

    private final ZeroneMailSenderService zeroneMailSenderService;
    private final KafkaService kafkaService;

    @KafkaListener(id = "zeroneMailConsumer1", topics = {"zeroneMailingTopic-1"}, containerFactory = "singleFactory")
    void listener(KafkaZeroneMailingDto data) {
        log.info("Email with topic - {} get from Kafka server.", data.getTopic());
        try {
            zeroneMailSenderService.emailSend(data.getEmail(), data.getTopic(), data.getBody());
        } catch (Exception e){
            log.info("Ошибка отправки письма - {}. Возвращаем в очередь для потворной отправки. Ошибка - {}", data.getTopic(), e.getMessage());
            kafkaService.sendRepeat(data);
        }

    }

    @KafkaListener(id = "zeroneMailConsumer2", topics = {"zeroneMailingRepeat-2"}, containerFactory = "singleFactory")
    void listenerRepeat(KafkaZeroneMailingDto data) {
        log.info(data.toString());
        try {
            zeroneMailSenderService.emailSend(data.getEmail(), data.getTopic(), data.getBody());
        } catch (Exception e){
            log.info("Ошибка повторной отправки почти. {}", e.getMessage());
            kafkaService.sendRepeat(data);
        }

    }

}

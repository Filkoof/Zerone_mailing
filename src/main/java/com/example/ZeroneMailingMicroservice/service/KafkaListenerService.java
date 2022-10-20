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

    @KafkaListener(id = "zeroneMailConsumer", topics = {"zeroneMailingTopic-1"}, containerFactory = "singleFactory")
    void listener(KafkaZeroneMailingDto data) {
        log.info(data.toString());
        try {
            zeroneMailSenderService.emailSend(data.getEmail(), data.getTopic(), data.getBody());
        } catch (Exception e){
            log.info("Ошибка отправки почти, нужно вернуть сообщение в очередь кафки назад.");
        }

    }

}

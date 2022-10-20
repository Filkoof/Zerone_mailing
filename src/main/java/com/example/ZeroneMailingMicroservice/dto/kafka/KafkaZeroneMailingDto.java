package com.example.ZeroneMailingMicroservice.dto.kafka;

import lombok.Data;

@Data
public class KafkaZeroneMailingDto {
    private String email;
    private String topic;
    private String body;
}

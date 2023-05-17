package org.rerooms.matchingservice.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.rerooms.matchingservice.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableAutoConfiguration
public class MatchResultProducerService {
    @Value("${kafka.producer.topic-name}")
    private String producerTopicName;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MatchService matchService;

    @Autowired
    public MatchResultProducerService(KafkaTemplate<String, String> kafkaTemplate, MatchService matchService) {
        this.kafkaTemplate = kafkaTemplate;
        this.matchService = matchService;
    }

    public void send(String message){
        log.info("message is: {}", message);
        kafkaTemplate.send(producerTopicName, message);
    }
}

package org.rerooms.matchingservice.controller;

import lombok.RequiredArgsConstructor;
import org.rerooms.matchingservice.kafka.producer.MatchResultProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class Test {
    private final MatchResultProducerService topicProducer;

    @GetMapping(value = "/test")
    public void send(){
        topicProducer.send("Test my message! Good!");
    }
}

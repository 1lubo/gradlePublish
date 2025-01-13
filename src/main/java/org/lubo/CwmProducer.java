package org.lubo;

import org.springframework.kafka.core.KafkaTemplate;

public class CwmProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public CwmProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

}

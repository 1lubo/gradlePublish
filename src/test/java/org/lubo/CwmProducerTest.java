package org.lubo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.verify;

class CwmProducerTest {

    private KafkaTemplate<String, String> kafkaTemplate;
    private CwmProducer cwmProducer;

    @BeforeEach
    void setUp() {
        kafkaTemplate = Mockito.mock(KafkaTemplate.class);
        cwmProducer = new CwmProducer(kafkaTemplate);
    }

    @Test
    void sendMessageSendsMessageToCorrectTopic() {
        String topic = "test-topic";
        String message = "test-message";

        cwmProducer.sendMessage(topic, message);

        verify(kafkaTemplate).send(topic, message);
    }

    @Test
    void sendMessageHandlesNullMessage() {
        String topic = "test-topic";
        String message = null;

        cwmProducer.sendMessage(topic, message);

        verify(kafkaTemplate).send(topic, message);
    }

    @Test
    void sendMessageHandlesEmptyMessage() {
        String topic = "test-topic";
        String message = "";

        cwmProducer.sendMessage(topic, message);

        verify(kafkaTemplate).send(topic, message);
    }
}
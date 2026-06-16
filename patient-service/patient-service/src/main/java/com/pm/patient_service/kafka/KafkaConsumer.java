package com.pm.patient_service.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    // This makes 'patient-service-group' show up in Kafka-UI
    @KafkaListener(topics = "patient", groupId = "patient-service-group")
    public void consume(byte[] data) {
        log.info("Successfully consumed event from Kafka. Payload size: {} bytes", data.length);

        // If you want to convert the bytes back to your PatientEvent:
        // PatientEvent event = PatientEvent.parseFrom(data);
        // log.info("Received event for Patient ID: {}", event.getPatientId());
    }
}

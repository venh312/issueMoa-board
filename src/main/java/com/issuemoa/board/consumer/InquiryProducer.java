package com.issuemoa.board.consumer;

import com.issuemoa.board.service.inquiry.InquirySaveProducerRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InquiryProducer {
    private static final String TOPIC_NAME = "issuemoa-topic";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(InquirySaveProducerRequest inquirySaveConsumerRequest) {
        kafkaTemplate.send(TOPIC_NAME, String.valueOf(inquirySaveConsumerRequest.id()), inquirySaveConsumerRequest.message());
        log.info("Produced message: {}", inquirySaveConsumerRequest);
    }
}

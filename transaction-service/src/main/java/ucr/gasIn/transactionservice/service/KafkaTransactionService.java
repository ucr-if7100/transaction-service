package ucr.gasIn.transactionservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ucr.gasIn.transactionservice.event.Event;
import ucr.gasIn.transactionservice.event.TransactionCreatedEvent;

@Component
public class KafkaTransactionService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaTransactionService.class);

    @KafkaListener(topics="transactionCreated", containerFactory = "kafkaListenerContainerFactory", groupId = "ucr.gasIn")
    public void consumer(Event<?> event){
        if(event.getClass().isAssignableFrom(TransactionCreatedEvent.class)){
            TransactionCreatedEvent transactionCreatedEvent = (TransactionCreatedEvent) event;

            logger.info("Message {}", transactionCreatedEvent.getPayload());
        }
    }
}

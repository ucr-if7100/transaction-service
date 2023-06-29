package ucr.gasIn.transactionservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import ucr.gasIn.transactionservice.event.Event;
import ucr.gasIn.transactionservice.event.TransactionCreatedEvent;

import java.io.IOException;

public class TransactionCreatedEventDeserializer implements Deserializer<Event<?>> {

    @Override
    public Event<?> deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, TransactionCreatedEvent.class);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing TransactionCreatedEvent", e);
        }
    }
}

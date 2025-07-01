package org.acme.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.UserEvent;
import org.acme.repository.UserEventEntity;
import org.eclipse.microprofile.reactive.messaging.*;

@ApplicationScoped
public class KafkaProcessor {

    @Inject
    EntityManager em;

    ObjectMapper mapper = new ObjectMapper();

    @Incoming("input-topic")
    @Outgoing("output-topic")
    @Transactional
    public String consume(String rawJson) throws Exception {
        UserEvent event = mapper.readValue(rawJson, UserEvent.class);

        // Manipulasi data
        event.action = "processed_" + event.action;

        // Simpan ke DB
        UserEventEntity entity = new UserEventEntity();
        entity.userId = event.userId;
        entity.action = event.action;
        entity.timestamp = event.timestamp;
        em.persist(entity);

        // Kirim ke output-topic
        return mapper.writeValueAsString(event);
    }
}

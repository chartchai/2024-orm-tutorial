package camt.demo.service;

import camt.demo.entity.Event;
import org.springframework.data.domain.Page;

public interface EventService {
    Integer getEventSize();

    Page<Event> getEvents(Integer pageSize, Integer page);

    Event getEvent(Long id);

    Event save(Event event);
}


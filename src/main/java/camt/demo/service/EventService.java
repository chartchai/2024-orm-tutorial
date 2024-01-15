package camt.demo.service;

import camt.demo.entity.Event;

import java.util.List;

public interface EventService {
    Integer getEventSize();


    Event getEvent(Long id);

    Event save(Event event);

    List<Event> getEvents();
}


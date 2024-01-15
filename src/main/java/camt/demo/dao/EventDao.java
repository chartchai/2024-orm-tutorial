package camt.demo.dao;

import camt.demo.entity.Event;

import java.util.List;


public interface EventDao {

    Integer getEventSize();
    List<Event> getEvents();





    Event getEvent(Long id);

    Event save(Event event);
}


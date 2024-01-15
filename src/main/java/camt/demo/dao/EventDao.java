package camt.demo.dao;

import camt.demo.entity.Event;
import org.springframework.data.domain.Page;


public interface EventDao {

    Integer getEventSize();

    Page<Event> getEvents(Integer pageSize, Integer page);

    Event getEvent(Long id);

    Event save(Event event);
}


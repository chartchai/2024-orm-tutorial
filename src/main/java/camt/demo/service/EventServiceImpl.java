package camt.demo.service;

import camt.demo.dao.EventDao;
import camt.demo.entity.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EventServiceImpl implements EventService {

    final EventDao eventDao;

    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }



    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    public Event save(Event event) {
        return eventDao.save(event);
    }

    @Override
    public List<Event> getEvents() {
        return eventDao.getEvents();
    }

}


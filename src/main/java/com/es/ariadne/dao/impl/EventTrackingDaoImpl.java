package com.es.ariadne.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.es.ariadne.dao.EventTrackingDao;
import com.es.ariadne.domain.EventEntity;
import com.es.ariadne.repository.EventRepository;

@Component
public class EventTrackingDaoImpl implements EventTrackingDao  {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<EventEntity> searchEventsByInterval(Long minValue, Long maxValue) {
		return eventRepository.searchEventByRange(minValue, maxValue);
	}

	@Override
	public List<EventEntity> searchEventsByFilter(List<Long> events) {
		return eventRepository.searchEventByFilter(events);
	}

	@Override
	public List<EventEntity> searchEventsBySource(Long source) {
		return eventRepository.searchEventBySource(source);
	}

}

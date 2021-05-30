package com.es.ariadne.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.ariadne.dao.EventTrackingDao;
import com.es.ariadne.domain.EventEntity;
import com.es.ariadne.service.EventTrackingService;

@Service
public class EventTrackingServiceImpl implements EventTrackingService {

	@Autowired
	private EventTrackingDao eventTrackingDao;

	@Override
	public List<EventEntity> searchEventsByInterval(Long minValue, Long maxValue) {
		return eventTrackingDao.searchEventsByInterval(minValue, maxValue);
	}

	@Override
	public List<EventEntity> searchEventsByFilter(List<Long> events) {
		return eventTrackingDao.searchEventsByFilter(events);
	}

	@Override
	public List<EventEntity> searchEventsBySource(Long source) {
		return eventTrackingDao.searchEventsBySource(source);
	}

	
}
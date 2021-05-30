package com.es.ariadne.service;

import java.util.List;

import com.es.ariadne.domain.EventEntity;

public interface EventTrackingService {
	
	List<EventEntity> searchEventsByInterval(Long minValue, Long maxValue);

	List<EventEntity> searchEventsByFilter(List<Long> events);

	List<EventEntity> searchEventsBySource(Long source);
}

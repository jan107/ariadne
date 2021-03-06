package com.es.ariadne.dao;

import java.util.List;

import com.es.ariadne.domain.EventEntity;

public interface EventTrackingDao {
	
	List<EventEntity> searchEventsByInterval(Long minValue, Long maxValue);

	List<EventEntity> searchEventsByFilter(List<Long> events);

	List<EventEntity> searchEventsBySource(Long source);
}

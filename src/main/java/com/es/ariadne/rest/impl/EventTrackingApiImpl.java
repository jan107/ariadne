package com.es.ariadne.rest.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.es.ariadne.domain.EventFilterRequest;
import com.es.ariadne.rest.EventTrackingApi;
import com.es.ariadne.service.EventTrackingService;
import com.es.ariadne.validation.EventTrackingValidation;

@Component
public class EventTrackingApiImpl implements EventTrackingApi {

	@Autowired
	private EventTrackingService eventTrackingService;
	
	@Autowired
	private EventTrackingValidation eventTrackingValidation;

	@Override
	public ResponseEntity getEventsByRange(Long minValue, Long maxValue) {
		return new ResponseEntity(eventTrackingService.searchEventsByInterval(minValue, maxValue), HttpStatus.OK);
	}

	@Override
	public ResponseEntity getEventsByFilter(EventFilterRequest eventFilterRequest) {
		
		if(eventTrackingValidation.isValidEventTrackingRequest(eventFilterRequest)) {
			return new ResponseEntity(eventTrackingService.searchEventsByFilter(eventFilterRequest.getEvents()), HttpStatus.OK);			
		}
		
		return new ResponseEntity(new ArrayList<>(), HttpStatus.OK);			
		
	}

	@Override
	public ResponseEntity getEventsByRange(Long source) {
		return new ResponseEntity(eventTrackingService.searchEventsBySource(source), HttpStatus.OK);
	}
}

package com.es.ariadne.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.es.ariadne.domain.CalorieTrackingRequest;
import com.es.ariadne.domain.CalorieViewTrackingRequest;
import com.es.ariadne.domain.Response;
import com.es.ariadne.domain.UserCalorieTrackingResponse;
import com.es.ariadne.rest.EventTrackingApi;
import com.es.ariadne.service.CalorieTrackingService;
import com.es.ariadne.service.EventTrackingService;

@Component
public class EventTrackingApiImpl implements EventTrackingApi {
	@Autowired
	private CalorieTrackingService calorieTrackingService;
	
	@Autowired
	private EventTrackingService eventTrackingService;
		    
	@Override
	public ResponseEntity addCalorie(@RequestBody CalorieTrackingRequest trackCalorieRequest) {
		this.calorieTrackingService.addCalorie(trackCalorieRequest);
		return new ResponseEntity(new Response(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity removeCalorie(@RequestBody CalorieTrackingRequest trackCalorieRequest) {
		this.calorieTrackingService.removeCalorie(trackCalorieRequest);
		return new ResponseEntity(new Response(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity viewCalorie(@RequestBody CalorieViewTrackingRequest trackCalorieRequest) {
		UserCalorieTrackingResponse userCalorieTrackingResponse = this.calorieTrackingService.viewCalorie(trackCalorieRequest);
		return new ResponseEntity(userCalorieTrackingResponse.getUserCalorieDailyTracking(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity getEvents(Long minValue, Long maxValue) {
		return new ResponseEntity(eventTrackingService.searchEventsByInterval(minValue, maxValue), HttpStatus.OK);
	}
}

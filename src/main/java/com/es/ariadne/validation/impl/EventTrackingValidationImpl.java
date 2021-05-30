package com.es.ariadne.validation.impl;

import org.springframework.stereotype.Component;

import com.es.ariadne.EventTrackingConstant;
import com.es.ariadne.domain.EventFilterRequest;
import com.es.ariadne.validation.EventTrackingValidation;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventTrackingValidationImpl implements EventTrackingValidation, EventTrackingConstant {
	@Override
	public boolean isValidEventTrackingRequest(EventFilterRequest request) {
		try {
			if(request != null && request.getEvents() != null && !request.getEvents().isEmpty() ) {
				return true;
			}
		}
		catch (Exception e) {
			log.error("There is an exception when perform validation", e);
		}
		return false;
	}
}

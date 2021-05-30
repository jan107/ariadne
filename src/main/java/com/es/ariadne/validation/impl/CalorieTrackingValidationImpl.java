package com.es.ariadne.validation.impl;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import com.es.ariadne.EventTrackingConstant;
import com.es.ariadne.domain.CalorieViewTrackingRequest;
import com.es.ariadne.validation.CalorieTrackingValidation;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CalorieTrackingValidationImpl implements CalorieTrackingValidation, EventTrackingConstant {
	@Override
	public boolean isValidCalorieTrackingRequest(CalorieViewTrackingRequest request) {
		try {
			String date = request.getDate();
			if (!Strings.isEmpty(date)) {
				formatter.parse(date);
			}
			return true;
		}
		catch (Exception e) {
			log.error("There is an exception when perform validation", e);
			return false;
		}
	}
}

package com.es.ariadne.validation;

import com.es.ariadne.domain.EventFilterRequest;

public interface EventTrackingValidation {
	boolean isValidEventTrackingRequest(EventFilterRequest request);
}

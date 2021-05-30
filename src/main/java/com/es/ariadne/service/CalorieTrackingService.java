package com.es.ariadne.service;

import com.es.ariadne.domain.CalorieTrackingRequest;
import com.es.ariadne.domain.CalorieViewTrackingRequest;
import com.es.ariadne.domain.UserCalorieTrackingResponse;

public interface CalorieTrackingService {
	public void addCalorie(CalorieTrackingRequest trackCalorieRequest);
	public void removeCalorie(CalorieTrackingRequest trackCalorieRequest);
	public UserCalorieTrackingResponse viewCalorie(CalorieViewTrackingRequest trackCalorieRequest);
}

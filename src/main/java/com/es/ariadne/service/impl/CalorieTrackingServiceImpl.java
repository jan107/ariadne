package com.es.ariadne.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.ariadne.dao.CalorieTrackingDao;
import com.es.ariadne.domain.CalorieTrackingRequest;
import com.es.ariadne.domain.CalorieViewTrackingRequest;
import com.es.ariadne.domain.UserCalorieDailyEntry;
import com.es.ariadne.domain.UserCalorieDetailEntry;
import com.es.ariadne.domain.UserCalorieTrackingResponse;
import com.es.ariadne.domain.UserHistoryEntity;
import com.es.ariadne.domain.UserHistoryEntry;
import com.es.ariadne.service.CalorieTrackingService;
import com.es.ariadne.util.CalorieTrackingUtils;
import com.es.ariadne.validation.CalorieTrackingValidation;

@Service
public class CalorieTrackingServiceImpl implements CalorieTrackingService {

	@Autowired
	private CalorieTrackingValidation calorieTrackingValidation;
	
	@Autowired
	private CalorieTrackingUtils calorieTrackingUtils;
	
	@Autowired
	private CalorieTrackingDao calorieTrackingDao;

	@Override
	public void addCalorie(CalorieTrackingRequest trackCalorieRequest) {
		this.calorieTrackingValidation.isValidCalorieTrackingRequest(trackCalorieRequest);

		UserHistoryEntity userHistoryEntity = this.calorieTrackingUtils.map(trackCalorieRequest, UserHistoryEntity.class);
		this.calorieTrackingDao.addUserHistory(userHistoryEntity.standardize());
	}

	@Override
	public void removeCalorie(CalorieTrackingRequest trackCalorieRequest) {
		this.calorieTrackingValidation.isValidCalorieTrackingRequest(trackCalorieRequest);

		UserHistoryEntity userHistoryEntity = this.calorieTrackingUtils.map(trackCalorieRequest, UserHistoryEntity.class);
		userHistoryEntity.markAsRemovedCalories();
		this.calorieTrackingDao.addUserHistory(userHistoryEntity.standardize());
	}

	@Override
	public UserCalorieTrackingResponse viewCalorie(CalorieViewTrackingRequest trackCalorieRequest) {
		this.calorieTrackingValidation.isValidCalorieTrackingRequest(trackCalorieRequest);
		
		Long userId = trackCalorieRequest.getUserId();
		Date requestDate = CalorieTrackingUtils.toDate(trackCalorieRequest.getDate());
		List<UserHistoryEntry> userHistoryList = this.calorieTrackingDao.viewUserHistory(userId, requestDate);
		
		return this.buildUserCalorieTrackingResponse(userHistoryList);
	}

	/**
	 * This method is to iterate all entries from User History table and group by Date
	 * Also Total calories
	 * @param userHistoryList
	 * @return
	 */
	private UserCalorieTrackingResponse buildUserCalorieTrackingResponse(List<UserHistoryEntry> userHistoryList) {
		UserCalorieTrackingResponse response = new UserCalorieTrackingResponse();
		
		// grouping logic for History Tracking by Date
		Map<Date, List<UserHistoryEntry>> mapTracking = userHistoryList.stream().collect(Collectors.groupingBy(u -> u.getDate()));
		mapTracking.forEach((k,v) -> {
			UserCalorieDailyEntry userCalorieDailyEntry = new UserCalorieDailyEntry();
			userCalorieDailyEntry.setDate(CalorieTrackingUtils.dateToString(k))
								.setTotal(v.stream().mapToLong(ude -> ude.getCalories()).sum());
			
			// collect History Detail entries
			userCalorieDailyEntry.setUserDailyEntries(v.stream().map( detailEntry -> 
																		new UserCalorieDetailEntry(detailEntry.getFoodId(), 
																									detailEntry.getFoodName(),
																									detailEntry.getCalories()))
																.collect(Collectors.toList()));
			// collect all Tracking for all days			
			response.addUserCalorieDailyEntry(userCalorieDailyEntry);
		});

		return response;
	}
}
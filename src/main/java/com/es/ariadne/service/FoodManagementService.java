package com.es.ariadne.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.ariadne.domain.*;

@Service
public interface FoodManagementService {
	public List<Food> getFoods();
	public List<Food> getFoods(Integer caloriesMin, Integer caloriesMax);
	public Boolean addFood(Food food);
	public Boolean removeFood(Long foodId);
}

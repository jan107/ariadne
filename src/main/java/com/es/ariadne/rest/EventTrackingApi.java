package com.es.ariadne.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.ariadne.domain.CalorieTrackingRequest;
import com.es.ariadne.domain.CalorieViewTrackingRequest;
import com.es.ariadne.domain.EventFilterRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public interface EventTrackingApi {

	@PostMapping(value = "/public/trackCalorie", 
			produces= {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Return all Activities of the user. It also can return Activities of the user on a specific date.", notes="This is a public API", response=List.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity viewCalorie(@RequestBody CalorieViewTrackingRequest trackCalorieRequest);
	
	@PutMapping(value = "/public/trackCalorie",
			produces= {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Add an activity of the user on the current date as default. It also can be on a specific date.", notes="This is a public API", response=String.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity addCalorie(@RequestBody CalorieTrackingRequest trackCalorieRequest);
	
	@DeleteMapping(value = "/public/trackCalorie",
			produces= {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Update (not Delete) an activity of the user on the current date as default. It also can be on a specific date.", notes="This is a public API", response=String.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity removeCalorie(@RequestBody CalorieTrackingRequest trackCalorieRequest);
	
	
	@GetMapping(value = "/public/getEventsByRange/{minValue}/{maxValue}", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Return all Events between minValue and maxValue", notes="This is a public API", response=List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Not found any event by range")
	})
	ResponseEntity getEventsByRange(@PathVariable("minValue") Long minValue, @PathVariable("maxValue") Long maxValue);
	
	
	@PostMapping(value = "/public/getEventsByFilter", 
			produces= {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Return all Events from event filter list.", notes="This is a public API", response=List.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity getEventsByFilter(@RequestBody EventFilterRequest eventFilterRequest);
	
	@GetMapping(value = "/public/getEventsBySource/{source}", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Return all Events filtered by source", notes="This is a public API", response=List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Not found any event by source")
	})
	ResponseEntity getEventsByRange(@PathVariable("source") Long source);
	
}
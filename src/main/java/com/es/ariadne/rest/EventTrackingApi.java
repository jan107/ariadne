package com.es.ariadne.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.ariadne.domain.EventFilterRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public interface EventTrackingApi {
	
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
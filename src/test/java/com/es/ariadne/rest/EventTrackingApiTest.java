package com.es.ariadne.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.es.ariadne.EventTrackingApplication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EventTrackingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode=DirtiesContext.ClassMode.AFTER_CLASS)
public class EventTrackingApiTest {

	@LocalServerPort
	private int port;
	
	@Before
	public void setup() {
		RestAssured.port = port;
	}
	
	@Test
	public void testGetEvents() {
		Response response = RestAssured.when().get("/eventTracking/public/getEventsByRange/1/2?minValue=1&maxValue=2");
		assertEquals("200 must be returned", HttpStatus.OK.value(), response.statusCode());
	}
	
	@Test
	public void testGetEventsWithRangeNotFound() {
		Response response = RestAssured.when().get("/eventTracking/public/getEventsByRange?minValue=1&maxValue=2");
		
		assertEquals("404 must be returned", HttpStatus.NOT_FOUND.value(), response.statusCode());
	}
	
}

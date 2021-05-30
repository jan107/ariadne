package com.es.ariadne.domain;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class EventFilterRequest {
	@NotEmpty(message="This is a required field")
	private List<Long> events;
}

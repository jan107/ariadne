package com.es.ariadne.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.es.ariadne.domain.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long>{

	/**
	 * To fetch Event by Range
	 * @param min
	 * @param max
	 * @return
	 */
	@Query("SELECT event FROM EventEntity event WHERE event.timestampevent BETWEEN :min AND :max")
	List<EventEntity> searchEventByRange(@Param("min") long min, @Param("max") long max);
}

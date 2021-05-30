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
	
	
	/**
	 * To fetch Event by Filter
	 * @param min
	 * @param max
	 * @return
	 */
	@Query("SELECT event FROM EventEntity event WHERE event.timestampevent IN :list")
	List<EventEntity> searchEventByFilter(@Param("list") List<Long> events);
	
	
	/**
	 * To fetch Event by source
	 * @param min
	 * @param max
	 * @return
	 */
	@Query("SELECT event FROM EventEntity event WHERE event.source = :source")
	List<EventEntity> searchEventBySource(@Param("source") Long source);
	
	
}

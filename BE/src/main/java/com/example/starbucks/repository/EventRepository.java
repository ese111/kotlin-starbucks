package com.example.starbucks.repository;

import com.example.starbucks.domain.Event;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {

	@Query("select e from Event e where :currentDateTime between e.startDateTime and e.endDateTime")
	List<Event> findByCurrentDateTimeIsBetweenStartDateTimeAndEndDateTime(
		@Param("currentDateTime") LocalDateTime currentDateTime);

	Event findByMainIsTrue();

	Event findByPopUpIsTrue();
}

package com.example.starbucks.service;

import com.example.starbucks.domain.Event;
import com.example.starbucks.dto.EventOngoingResponse;
import com.example.starbucks.dto.EventResponse;
import com.example.starbucks.repository.EventRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class EventService {

	private final EventRepository eventRepository;

	public List<EventOngoingResponse> findOngoingEvents() {
		return eventRepository.findByCurrentDateTimeIsBetweenStartDateTimeAndEndDateTime(
				LocalDateTime.now())
			.stream().map(EventOngoingResponse::new)
			.collect(Collectors.toList());
	}

	public EventResponse findMainEvent(boolean param) {
		return new EventResponse(eventRepository.findByMain(param));
	}

}

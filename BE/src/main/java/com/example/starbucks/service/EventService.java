package com.example.starbucks.service;

import com.example.starbucks.dto.EventResponse;
import com.example.starbucks.dto.MainEventResponse;
import com.example.starbucks.dto.PopupEventResponse;
import com.example.starbucks.repository.EventRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class EventService {

	private final EventRepository eventRepository;

	public List<EventResponse> findOngoingEvents() {
		return eventRepository.findByCurrentDateTimeIsBetweenStartDateTimeAndEndDateTime(
				LocalDateTime.now())
			.stream().map(EventResponse::new)
			.collect(Collectors.toList());
	}

	public MainEventResponse findMainEvent() {
		return new MainEventResponse(eventRepository.findByMainIsTrue());
	}

	public PopupEventResponse findPopUpEvent() {
		return new PopupEventResponse(eventRepository.findByPopUpIsTrue());
	}

	public List<EventResponse> findAllBySort(String sortBy, String orderBy) {
		Sort sort = Sort.by(sortBy);
		if ("desc".equals(orderBy)) {
			sort = sort.descending();
		}

		return eventRepository.findAll(sort)
			.stream().map(EventResponse::new)
			.collect(Collectors.toList());
	}
}

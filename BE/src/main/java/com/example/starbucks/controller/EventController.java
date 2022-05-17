package com.example.starbucks.controller;

import com.example.starbucks.dto.EventResponse;
import com.example.starbucks.dto.MainEventResponse;
import com.example.starbucks.dto.PopupEventResponse;
import com.example.starbucks.service.EventService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EventController {

	private final EventService eventService;

	@GetMapping("/events/ongoing")
	public List<EventResponse> getOngoingEvents() {
		return eventService.findOngoingEvents();
	}

	@GetMapping("/events/main")
	public MainEventResponse getMainEvent() {
		return eventService.findMainEvent();
	}

	@GetMapping("/events/popup")
	public PopupEventResponse getPopupEvent() {
		return eventService.findPopUpEvent();
	}

	@GetMapping("/events")
	public List<EventResponse> getSortedEvents(
		@RequestParam("sort-by") String sortBy,
		@RequestParam(value = "order-by", required = false) String orderBy) {
		return eventService.findAllBySort(sortBy, orderBy);
	}
}

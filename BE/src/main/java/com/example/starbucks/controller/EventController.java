package com.example.starbucks.controller;

import com.example.starbucks.dto.EventOngoingResponse;
import com.example.starbucks.service.EventService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EventController {

	private final EventService eventService;

	@GetMapping("/events/ongoing")
	public List<EventOngoingResponse> getOngoingEvents() {
		return eventService.findOngoingEvents();
	}
}

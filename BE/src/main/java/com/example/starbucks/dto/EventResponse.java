package com.example.starbucks.dto;

import com.example.starbucks.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventResponse {

	private Long id;
	private String imageUrl;
	private String title;
	private String description;

	public EventResponse(Event event) {
		this.id = event.getId();
		this.imageUrl = event.getImageUrl();
		this.title = event.getTitle();
		this.description = event.getDescription();
	}
}

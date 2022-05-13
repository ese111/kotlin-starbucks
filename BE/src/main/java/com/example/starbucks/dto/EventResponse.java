package com.example.starbucks.dto;


import com.example.starbucks.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class EventResponse {

    private Long id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String description;
    private String imageUrl;

    public EventResponse(Event event) {
        this.id = event.getId();
        this.startDateTime = event.getStartDateTime();
        this.endDateTime = event.getEndDateTime();
        this.description = event.getDescription();
        this.imageUrl = event.getImageUrl();
    }
}

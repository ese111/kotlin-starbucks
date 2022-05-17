package com.example.starbucks.dto;


import com.example.starbucks.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PopupEventResponse {

    private Long id;
    private String title;
    private String target;
    private String eventProductName;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String description;
    private String imageUrl;

    public PopupEventResponse(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.target = event.getTarget();
        this.eventProductName = event.getEventProductName();
        this.startDateTime = event.getStartDateTime();
        this.endDateTime = event.getEndDateTime();
        this.description = event.getDescription();
        this.imageUrl = event.getImageUrl();
    }
}

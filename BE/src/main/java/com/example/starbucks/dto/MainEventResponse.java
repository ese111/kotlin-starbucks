package com.example.starbucks.dto;

import com.example.starbucks.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MainEventResponse {

    private String imageUrl;

    public MainEventResponse(Event event) {
        this.imageUrl = event.getImageUrl();
    }
}

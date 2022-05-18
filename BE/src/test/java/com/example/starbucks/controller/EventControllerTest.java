package com.example.starbucks.controller;

import com.example.starbucks.config.RestDocsConfiguration;
import com.example.starbucks.dto.EventResponse;
import com.example.starbucks.dto.MainEventResponse;
import com.example.starbucks.dto.PopupEventResponse;
import com.example.starbucks.service.EventService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(RestDocsConfiguration.class)
@WebMvcTest(EventController.class)
@DisplayName("EventController 클래스")
class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EventService eventService;

    EasyRandom generator;

    @BeforeEach
    void setUp(){
        generator = new EasyRandom();
    }

    @Test
    void 현재_진행중인_이벤트를_모두_조회한다() throws Exception {
        given(eventService.findOngoingEvents())
                .willReturn(generator.objects(EventResponse.class, 2).collect(Collectors.toList()));

        ResultActions perform = mockMvc.perform(get("/events/ongoing"));

        perform
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void 이벤트_시작_날짜를_내림차순으로_정렬한_이벤트를_모두_조회한다() throws Exception {
        given(eventService.findAllBySort("start-date-time", "desc"))
                .willReturn(generator.objects(EventResponse.class, 5).collect(Collectors.toList()));

        ResultActions perform = mockMvc.perform(
                get("/events?sort-by=start-date-time&order-by=desc"));

        perform
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void 메인_이벤트를_조회한다() throws Exception {
        given(eventService.findMainEvent())
                .willReturn(generator.nextObject(MainEventResponse.class));

        ResultActions perform = mockMvc.perform(get("/events/main"));

        perform
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void 팝업_이벤트를_조회한다() throws Exception {
        given(eventService.findPopUpEvent())
                .willReturn(generator.nextObject(PopupEventResponse.class));

        ResultActions perform = mockMvc.perform(get("/events/popup"));

        perform
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }
}

package com.example.starbucks.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.starbucks.config.RestDocsConfiguration;
import com.example.starbucks.dto.EventOngoingResponse;
import com.example.starbucks.service.EventService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@Import(RestDocsConfiguration.class)
@AutoConfigureRestDocs
@WebMvcTest(EventController.class)
@DisplayName("EventController 클래스")
class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EventService productService;

    @Test
    void 현재_진행중인_이벤트를_모두_조회한다() throws Exception {
        given(productService.findOngoingEvents())
            .willReturn(List.of(
                new EventOngoingResponse(1L, "http://~~~", "제목 1", "설명11111"),
                new EventOngoingResponse(2L, "http://~~~", "제목 2", "설명22222"),
                new EventOngoingResponse(3L, "http://~~~", "제목 3", "설명33333"),
                new EventOngoingResponse(4L, "http://~~~", "제목 4", "설명44444"),
                new EventOngoingResponse(5L, "http://~~~", "제목 5", "설명55555")));

        ResultActions perform = mockMvc.perform(get("/events/ongoing"));

        perform
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(document("event-ongoing"));
    }

}

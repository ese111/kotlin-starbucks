package com.example.starbucks.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.starbucks.config.RestDocsConfiguration;
import com.example.starbucks.dto.EventResponse;
import com.example.starbucks.dto.MainEventResponse;
import com.example.starbucks.service.EventService;

import java.time.LocalDateTime;
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
    EventService eventService;

    @Test
    void 현재_진행중인_이벤트를_모두_조회한다() throws Exception {
        given(eventService.findOngoingEvents())
            .willReturn(List.of(
                new EventResponse(1L, "http://~~~", "제목 1", "설명11111"),
                new EventResponse(2L, "http://~~~", "제목 2", "설명22222"),
                new EventResponse(3L, "http://~~~", "제목 3", "설명33333"),
                new EventResponse(4L, "http://~~~", "제목 4", "설명44444"),
                new EventResponse(5L, "http://~~~", "제목 5", "설명55555")));

        ResultActions perform = mockMvc.perform(get("/events/ongoing"));

        perform
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(document("event-ongoing"));
    }

    @Test
    void 이벤트_시작_날짜를_내림차순으로_정렬한_이벤트를_모두_조회한다() throws Exception {
        given(eventService.findAllBySort("start-date-time", "desc"))
            .willReturn(List.of(
                new EventResponse(1L, "http://~~~", "제목 1", "설명11111"),
                new EventResponse(2L, "http://~~~", "제목 2", "설명22222"),
                new EventResponse(3L, "http://~~~", "제목 3", "설명33333"),
                new EventResponse(4L, "http://~~~", "제목 4", "설명44444"),
                new EventResponse(5L, "http://~~~", "제목 5", "설명55555")));

        ResultActions perform = mockMvc.perform(
            get("/events?sort-by=start-date-time&order-by=desc"));

        perform
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(document("event-sort"));
    }

//    @Test
//    void 메인_이벤트를_조회한다() throws Exception {
//        LocalDateTime startDate = LocalDateTime.of(2021, 10, 11, 00, 00);
//        LocalDateTime endDate = LocalDateTime.of(2021, 10, 22, 00, 00);
//
//        given(eventService.findMainEvent())
//                .willReturn(new MainEventResponse(1L, '스타벅스트', '스타벅스트 리워드 회원', '스타벅스트 딜리버리 음료',
//                        startDate, endDate, '기간 내 오후 2시~6시 등록된 카드로 주문시 영수증당 별 추가 증정',
//                        'https://s3.ap-northeast-2.amazonaws.com/lucas-image.codesquad.kr/1627033273796event-bg.png'));
//
//        ResultActions perform = mockMvc.perform(get("events/main"));
//
//        perform
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andDo(document("main-event"));
//    }
}

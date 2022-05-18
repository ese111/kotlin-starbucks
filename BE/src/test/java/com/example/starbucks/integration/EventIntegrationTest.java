package com.example.starbucks.integration;

import com.example.starbucks.config.RestDocsConfiguration;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.transaction.annotation.Transactional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

@Import(RestDocsConfiguration.class)
@AutoConfigureRestDocs
@ExtendWith({RestDocumentationExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@DisplayName("Event 통합 테스트")
public class EventIntegrationTest {

    @LocalServerPort
    int port;

    RequestSpecification documentationSpec;

    @BeforeEach
    void setup(RestDocumentationContextProvider restDocumentation) {
        RestAssured.port = port;
        documentationSpec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    void 진행_중인_이벤트를_모두_조회한다() {
        given(documentationSpec)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .filter(document("get-event-ongoing", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))

                .when()
                .get("/events/ongoing")

                .then()
                .statusCode(HttpStatus.OK.value())
                .assertThat()
                .body("", hasSize(2))
                .body("[0].id", equalTo(2))
                .body("[0].imageUrl", equalTo("https://image.istarbucks.co.kr/upload/promotion/WEB_THUM_20211231080741168.jpg"))
                .body("[0].title", equalTo("22 서머 e-프리퀀시 이벤트 안내"))
                .body("[0].description", equalTo("다가올 여행의 모양은 모두 다르지만, 즐거운 여행 속 '나'에게 기대감과 즐거움을 주는 스타벅스의 여름 이야기."))
                .body("[1].id", equalTo(3))
                .body("[1].imageUrl", equalTo(null))
                .body("[1].title", equalTo("만원당 별 적립 이벤트"))
                .body("[1].description", equalTo("회원 계정에 등록된 스타벅스 카드로 결제 시, 1만원당 별 1개를 즉시 추가로 드립니다!"));
    }

    @Test
    void 초기화면_팝업_이벤트를_조회한다() throws Exception{
        given(documentationSpec)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .filter(document("get-popup-event", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))

                .when()
                .get("/events/popup")

                .then()
                .statusCode(HttpStatus.OK.value())
                .assertThat()
                .body("id", equalTo(1))
                .body("title", equalTo("스타벅스트"))
                .body("target", equalTo("스타벅스트 리워드 회원"))
                .body("eventProductName", equalTo("스타벅스트 딜리버리 음료"))
                .body("startDateTime", equalTo("2021-10-11T00:00:00"))
                .body("endDateTime", equalTo("2021-10-22T00:00:00"))
                .body("description", equalTo("기간 내 오후 2시~6시 등록된 카드로 주문시 영수증당 별 추가 증정"));
    }

    @Test
    void 메인_이벤트를_조회한다() throws Exception{
        given(documentationSpec)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .filter(document("get-main-event", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))

                .when()
                .get("/events/main")

                .then()
                .statusCode(HttpStatus.OK.value())
                .assertThat()
                .body("imageUrl", equalTo("https://image.istarbucks.co.kr/upload/promotion/WEB_THUM_20211231080741168.jpg"));
    }

    @Test
    void 이벤트_시작날짜를_내림차순_정렬하여_이벤트를_조회한다() throws Exception{
        given(documentationSpec)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .filter(document("get-all-event-by-desc", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))

                .when()
                .get("/events?sort-by=startDateTime&order-by=desc")

                .then()
                .statusCode(HttpStatus.OK.value())
                .assertThat()
                .body("", hasSize(5))
                .body("[0].id", equalTo(5))
                .body("[0].imageUrl", equalTo(null))
                .body("[0].title", equalTo("스타벅스 현대카드 5월 한정 혜택"))
                .body("[0].description", equalTo("별처럼 쏟아지는 선물같은 혜택 스타벅스 현대카드가 준비했어요!"))
                .body("[1].id", equalTo(2))
                .body("[1].imageUrl", equalTo("https://image.istarbucks.co.kr/upload/promotion/WEB_THUM_20211231080741168.jpg"))
                .body("[1].title", equalTo("22 서머 e-프리퀀시 이벤트 안내"))
                .body("[1].description", equalTo("다가올 여행의 모양은 모두 다르지만, 즐거운 여행 속 '나'에게 기대감과 즐거움을 주는 스타벅스의 여름 이야기."));
    }

}

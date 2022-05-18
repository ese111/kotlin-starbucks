package com.example.starbucks.integration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@DisplayName("Event 통합 테스트")
public class EventIntegrationTest {

	@LocalServerPort
	int port;

	@BeforeEach
	void setup() {
		RestAssured.port = port;
	}

	@Test
	void 진행_중인_이벤트를_5개_조회한다() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

			.when()
			.get("/events/ongoing")

			.then()
			.statusCode(HttpStatus.OK.value())
			.assertThat()
			.body("", hasSize(2))
			.body("[0].id", equalTo(2))
			.body("[0].imageUrl", equalTo(
				"https://image.istarbucks.co.kr/upload/promotion/WEB_THUM_20211231080741168.jpg"))
			.body("[0].title", equalTo("22 서머 e-프리퀀시 이벤트 안내"))
			.body("[0].description",
				equalTo("다가올 여행의 모양은 모두 다르지만, 즐거운 여행 속 '나'에게 기대감과 즐거움을 주는 스타벅스의 여름 이야기."))
			.body("[1].id", equalTo(3))
			.body("[1].imageUrl", equalTo(null))
			.body("[1].title", equalTo("만원당 별 적립 이벤트"))
			.body("[1].description", equalTo("회원 계정에 등록된 스타벅스 카드로 결제 시, 1만원당 별 1개를 즉시 추가로 드립니다!"));
	}
}

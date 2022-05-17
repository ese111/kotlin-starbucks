package com.example.starbucks.integration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest
@Transactional
class CategoryIntegrationTest {

	@Test
	void 특정_카테고리와_관련된_상품을_조회한다() {
		given()
			.accept(MediaType.APPLICATION_JSON_VALUE)

		.when()
			.get("/categories/1")

		.then()
			.statusCode(HttpStatus.OK.value())
			.assertThat()
			.body("categoryName", equalTo("콜드 브루"))
			.body("products", hasSize(5))
			.body("products[0].id", equalTo(2))
			.body("products[0].imageUrl",
				equalTo("https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000038]_20210430113202595.jpg"))
			.body("products[0].koreanName", equalTo("콜드 브루"))
			.body("products[0].englishName", equalTo("Cold brew"))
			.body("products[0].price", equalTo(4900))
			.body("products[0].best", equalTo(true))
			.body("products[1].id", equalTo(10))
			.body("products[1].imageUrl",
				equalTo("https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000479]_20210426091844065.jpg"))
			.body("products[1].koreanName", equalTo("나이트로 콜드 브루"))
			.body("products[1].englishName", equalTo("Nitro Cold Brew"))
			.body("products[1].price", equalTo(6000))
			.body("products[1].best", equalTo(true));
	}
}

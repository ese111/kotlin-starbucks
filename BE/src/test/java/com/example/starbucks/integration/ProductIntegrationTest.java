package com.example.starbucks.integration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

import com.example.starbucks.config.RestDocsConfiguration;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import javax.transaction.Transactional;
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

@Import(RestDocsConfiguration.class)
@AutoConfigureRestDocs
@ExtendWith({RestDocumentationExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@DisplayName("Product 통합 테스트")
class ProductIntegrationTest {

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
	void 랜덤으로_5개의_상품을_조회한다() {
		given(documentationSpec)
			.accept(MediaType.APPLICATION_JSON_VALUE)
			.filter(document("get-product-recommend", preprocessRequest(prettyPrint()),
				preprocessResponse(prettyPrint())))

			.when()
			.get("/products/recommend")

			.then()
			.statusCode(HttpStatus.OK.value())
			.assertThat()
			.body("", hasSize(5));
	}

	@Test
	void 상품_상세_정보를_조회한다() {
		given(documentationSpec)
			.accept(MediaType.APPLICATION_JSON_VALUE)
			.filter(document("get-product-detail", preprocessRequest(prettyPrint()),
				preprocessResponse(prettyPrint())))

			.when()
			.get("/products/1")

			.then()
			.statusCode(HttpStatus.OK.value())
			.assertThat()
			.body("id", equalTo(1))
			.body("koreanName", equalTo("카페라떼"))
			.body("englishName", equalTo("Caffe Latte"))
			.body("description", equalTo("대표적인 카페 라떼"))
			.body("price", equalTo(5000))
			.body("calorie", equalTo(110))
			.body("sugars", equalTo(9))
			.body("na", equalTo(8))
			.body("caffeine", equalTo(75))
			.body("fat", equalTo(6))
			.body("protein", equalTo(6))
			.body("imageUrl", equalTo(
				"https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[41]_20210415133833879.jpg"));
	}

	@Test
	void 주문량이_가장_높은_상품_5개를_조회한다() {
		given(documentationSpec)
			.accept(MediaType.APPLICATION_JSON_VALUE)
			.filter(document("get-product-popular", preprocessRequest(prettyPrint()),
				preprocessResponse(prettyPrint())))

			.when()
			.get("/products?sort-by=orderCount&order-by=desc")

			.then()
			.statusCode(HttpStatus.OK.value())
			.assertThat()
			.body("", hasSize(5))
			.body("[0].id", equalTo(1))
			.body("[0].koreanTitle", equalTo("카페라떼"))
			.body("[0].imageUrl", equalTo(
				"https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[41]_20210415133833879.jpg"))
			.body("[1].id", equalTo(2))
			.body("[1].koreanTitle", equalTo("콜드 브루"))
			.body("[1].imageUrl", equalTo(
				"https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000038]_20210430113202595.jpg"))
			.body("[2].id", equalTo(3))
			.body("[2].koreanTitle", equalTo("바닐라 크림 프라푸치노"))
			.body("[2].imageUrl", equalTo(
				"https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[41]_20210415133833879.jpg"))
			.body("[3].id", equalTo(4))
			.body("[3].koreanTitle", equalTo("쿨라임 피지오"))
			.body("[3].imageUrl", equalTo(
				"https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[107051]_20210419112152119.jpg"))
			.body("[4].id", equalTo(5))
			.body("[4].koreanTitle", equalTo("카페 아메리카노"))
			.body("[4].imageUrl", equalTo(
				"https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[41]_20210415133833879.jpg"));
	}
}

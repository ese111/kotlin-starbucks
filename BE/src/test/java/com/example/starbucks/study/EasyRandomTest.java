package com.example.starbucks.study;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.starbucks.domain.Category;
import com.example.starbucks.domain.CategoryProduct;
import com.example.starbucks.domain.CategoryType;
import com.example.starbucks.domain.Product;
import java.time.LocalDateTime;
import java.util.List;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.jeasy.random.api.Randomizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("EasyRandom 학습 테스트")
class EasyRandomTest {

	@Test
	void 단일_객체를_생성한다() {
		EasyRandom generator = new EasyRandom();
		Product product = generator.nextObject(Product.class);

		assertThat(product).isNotNull();
		assertThat(product.getId()).isNotNull();
		assertThat(product.getKoreanName()).isNotNull();
		assertThat(product.getDescription()).isNotNull();
		assertThat(product.getPrice()).isNotNull();
		assertThat(product.getCalorie()).isNotNull();
	}

	@Test
	void 단일_객체_내부의_기본형_타입이_아닌_다른_객체까지_생성한다() {
		EasyRandom generator = new EasyRandom();
		Category category = generator.nextObject(Category.class);

		List<CategoryProduct> categoryProducts = category.getCategoryProducts();
		CategoryProduct categoryProduct = categoryProducts.get(0);
		Product product = categoryProduct.getProduct();

		assertThat(category).isNotNull();
		assertThat(categoryProducts).isNotEmpty();
		assertThat(categoryProduct).isNotNull();
		assertThat(product).isNotNull();
		assertThat(product.getKoreanName()).isNotNull();
	}

	@Test
	void 원하는_범위의_랜덤_값을_가진_객체를_생성한다() {
		EasyRandomParameters parameters = new EasyRandomParameters();
		parameters.stringLengthRange(3, 3);
		parameters.collectionSizeRange(2, 2);

		EasyRandom generator = new EasyRandom(parameters);
		Category category = generator.nextObject(Category.class);

		assertThat(category.getKoreanName().length()).isEqualTo(3);
		assertThat(category.getCategoryProducts().size()).isEqualTo(2);
	}

	@Test
	void 특정_필드명_또는_타입은_랜덤_값_생성을_하지_않을_수_있다() {
		EasyRandomParameters parameters = new EasyRandomParameters();
		parameters.excludeField(FieldPredicates.named("englishName"));
		parameters.excludeField(FieldPredicates.ofType(CategoryType.class));

		EasyRandom generator = new EasyRandom(parameters);
		Category category = generator.nextObject(Category.class);

		assertThat(category.getEnglishName()).isNull();
		assertThat(category.getType()).isNull();
	}

	@Test
	void 자세한_랜덤_값을_가진_객체를_생성한다() {
		EasyRandomParameters parameters = new EasyRandomParameters();
		parameters.randomize(DateTimeInfo.class, new DateTimeInfoRandomizer());

		EasyRandom generator = new EasyRandom(parameters);
		DateTimeInfo dateTimeInfo = generator.nextObject(DateTimeInfo.class);

		assertThat(dateTimeInfo.getCreateDateTime()).isNotNull();
		assertThat(dateTimeInfo.getEndDateTime()).isNotNull();
		assertThat(dateTimeInfo.getCreateDateTime().plusMonths(3))
			.isEqualTo(dateTimeInfo.getEndDateTime());
	}

	static class DateTimeInfo {
		private LocalDateTime createDateTime;
		private LocalDateTime endDateTime;

		public DateTimeInfo(LocalDateTime createDateTime, LocalDateTime endDateTime) {
			this.createDateTime = createDateTime;
			this.endDateTime = endDateTime;
		}

		public LocalDateTime getCreateDateTime() {
			return createDateTime;
		}

		public LocalDateTime getEndDateTime() {
			return endDateTime;
		}
	}

	static class DateTimeInfoRandomizer implements Randomizer<DateTimeInfo> {

		@Override
		public DateTimeInfo getRandomValue() {
			LocalDateTime createDateTime = LocalDateTime.now();
			LocalDateTime endDateTime = createDateTime.plusMonths(3);
			return new DateTimeInfo(createDateTime, endDateTime);
		}
	}
}

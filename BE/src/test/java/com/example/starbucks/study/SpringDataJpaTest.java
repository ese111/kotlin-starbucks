package com.example.starbucks.study;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.starbucks.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class SpringDataJpaTest {

	@Autowired
	ProductRepository productRepository;

	@Test
	void Sort_객체를_생성할_때_엔티티의_필드명을_넣어줘야_한다() {
		productRepository.findAll(Sort.by("koreanName"));
	}

	@Test
	void Sort_객체를_생성할_때_데이터베이스_필드명을_넣어준다면_에러가_발생한다() {
		assertThatThrownBy(() -> productRepository.findAll(Sort.by("korean_name")))
			.isInstanceOf(PropertyReferenceException.class);
	}
}

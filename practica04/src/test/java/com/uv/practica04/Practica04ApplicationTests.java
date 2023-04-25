package com.uv.practica04;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ActiveProfiles("test")
@SpringBootTest
@Import(TestConfiguration.class)
@ContextConfiguration(classes = TestConfiguration.class)
class Practica04ApplicationTests {

	@Test
	void contextLoads() {
	}

}

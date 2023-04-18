package com.ssafy.hello.di6.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ssafy.hello.di6"})
public class ApplicationConfig {
	
	
	@Bean // <Bean> 태그 역할 에노테이션
		public BoardService service() {
		BoardService service = new BoardService();
		return;
	}
}

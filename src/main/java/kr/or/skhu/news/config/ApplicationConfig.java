package kr.or.skhu.news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import kr.or.skhu.news.service.impl.JsoupServiceImpl;

// 스프링 설정 class dao와 dto class를 찾아 scan함 (메모리에 올려둠)
@Configuration
@ComponentScan(basePackages = { "kr.or.skhu.news.dao",
								"kr.or.skhu.news.dto",
								"kr.or.skhu.news.service",
								"kr.or.skhu.news.service.impl"})
@EnableScheduling
@Import({ DBConfig.class })
public class ApplicationConfig {

	@Bean
	public JsoupServiceImpl jsoupSerivceImpl() {
		return new JsoupServiceImpl();
	}
}

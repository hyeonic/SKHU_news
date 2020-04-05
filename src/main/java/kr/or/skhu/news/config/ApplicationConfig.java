package kr.or.skhu.news.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 스프링 설정 class dao와 dto class를 찾아 scan함 (메모리에 올려둠)
@Configuration
@ComponentScan(basePackages = { "kr.or.skhu.notice.dao",  "kr.or.skhu.notice.dto"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}

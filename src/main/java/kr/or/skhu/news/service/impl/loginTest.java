package kr.or.skhu.news.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.skhu.news.config.ApplicationConfig;
import kr.or.skhu.news.dto.UserInfo;
import kr.or.skhu.news.service.UserInfoService;

public class loginTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		UserInfoService uid = ac.getBean(UserInfoService.class);


		UserInfo userInfo = new UserInfo("test", "test", "test");

		uid.signUp(userInfo);


	}

}

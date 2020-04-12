package kr.or.skhu.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.skhu.news.dto.UserInfo;
import kr.or.skhu.news.service.UserInfoService;

@Controller
public class UserInfoController {

	@Autowired
	UserInfoService userInfoService;

	@PostMapping(path = "/signUp")
	public String signUp(@RequestParam("userId") String userId,
						 @RequestParam("userPassword") String userPassword,
						 @RequestParam("userName") String userName) {

		UserInfo userInfo = new UserInfo(userId, userPassword, userName);

		userInfoService.signUp(userInfo);

		return "home";
	}
}

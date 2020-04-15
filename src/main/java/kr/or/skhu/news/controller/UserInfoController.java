package kr.or.skhu.news.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
						 @RequestParam("userName") String userName, 
						 HttpServletRequest request) {

		
		System.out.println(request.getParameter("userId"));
		System.out.println(request.getParameter("userPassword"));
		System.out.println(request.getParameter("userName"));

		UserInfo userInfo = new UserInfo(request.getParameter("userId")
                , request.getParameter("userPassword")
                , request.getParameter("userName")
                );
		
		userInfoService.signUp(userInfo);

		return "main";
	}
	
}

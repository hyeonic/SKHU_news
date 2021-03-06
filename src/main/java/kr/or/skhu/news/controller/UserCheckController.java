package kr.or.skhu.news.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.skhu.news.service.UserInfoService;

// UserInfo table을 JSON 형태로 담아 map 객체를 return
@Controller
@RequestMapping
public class UserCheckController {

	@Autowired
	UserInfoService userInfoService;

	@PostMapping(path="/userCheck")
	public String loginCheck(HttpServletRequest request, ModelMap model) {

		String userId = request.getParameter("userId");

		System.out.print("request parameter : userId["+userId+"] == >");
		boolean isUserExist = userInfoService.isUserExist(userId);

		System.out.println(isUserExist ? "is Exist" : "is not Exist");
		model.addAttribute("isUserExist", isUserExist);

		return "userCheck";
	}
}

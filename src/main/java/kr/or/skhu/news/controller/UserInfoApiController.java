package kr.or.skhu.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.skhu.news.dto.UserInfo;
import kr.or.skhu.news.service.UserInfoService;

// UserInfo table을 JSON 형태로 담아 map 객체를 return
@RestController
@RequestMapping(path="/userCheck")
public class UserInfoApiController {

	@Autowired
	UserInfoService userInfoService;

	// /userCheck url로 get방식으로 JSON 전달
	@GetMapping
	public Map<String, Object> loginCheck() {
		//입력받은 userInfo -> db 검사
		//db에서 userInfo가 존재한다면 가져옴. SQL까지 끝 2단
		//
		
		boolean isUserExist = userInfoService.isUserExist(userInfo);		//2단
		
		Map<String, Object> map = new HashMap<>();

		map.put("userInfoList", userInfoList);

		return map;
	}
}

package kr.or.skhu.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	@PostMapping
	public Map<String, Object> userInfoList() {
		List<UserInfo> userInfoList = userInfoService.getUserInfo();

		Map<String, Object> map = new HashMap<>();

		map.put("userInfoList", userInfoList);

		return map;
	}
}

package kr.or.skhu.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {

	@GetMapping(path = "/notice")
	public String notice() {
		return "main";
	}
}

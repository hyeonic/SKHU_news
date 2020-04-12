package kr.or.skhu.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.skhu.news.dto.Category;
import kr.or.skhu.news.dto.Notice;
import kr.or.skhu.news.service.NoticeService;

// Notice Table 과 Category Table을 JSON 형태로 담아 map 객체를 return
@RestController
@RequestMapping(path="/notices")
public class NoticeApiController {

	@Autowired
	NoticeService noticeService;

	// /notice url로 get방식으로 JSON 전달
	@GetMapping
	public Map<String, Object> noticeList() {
		List<Notice> noticeList = noticeService.getNotices();
		List<Category> categoryList = noticeService.getCategories();

		Map<String, Object> map = new HashMap<>();

		map.put("noticeList", noticeList);
		map.put("categoryList", categoryList);

		return map;
	}

	@PostMapping("/{categoryId}")
	public Map<String, Object> noticeByCategoryList(@PathVariable(name="categoryId") int id, HttpServletRequest request) {

		List<Notice> noticeByCategoryList = noticeService.getNotices();
		List<Category> categoryList = noticeService.getCategories();
		Map<String, Object> map = new HashMap<>();

		map.put("noticeByCategoryList", noticeByCategoryList);
		map.put("categoryList", categoryList);

		return map;

	}
}

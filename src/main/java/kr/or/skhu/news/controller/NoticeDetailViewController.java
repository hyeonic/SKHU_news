package kr.or.skhu.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.or.skhu.news.service.NoticeService;

@Controller
public class NoticeDetailViewController {

	@Autowired
	NoticeService noticeService;

	@GetMapping(path="/detail/{idx}")
	public String detailView(@PathVariable(name="idx") int idx, ModelMap model) {

		String html = noticeService.getHtml(idx);
		System.out.print("request parameter : idx["+idx+"] == >");

		model.addAttribute("html", html);

		return "noticeDetail";
	}
}

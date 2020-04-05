package kr.or.skhu.news.service;

import java.util.List;

import kr.or.skhu.news.dto.Category;
import kr.or.skhu.news.dto.Notice;

public interface NoticeService {
	public List<Notice> getNotices();
	public List<Category> getCategories();
	public int insertNotice(List<Notice> noticeList);
}

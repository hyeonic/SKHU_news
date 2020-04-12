package kr.or.skhu.news.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.skhu.news.dto.Category;
import kr.or.skhu.news.dto.Notice;

@Service
public interface NoticeService {
	public List<Notice> getNotices();
	public List<Notice> getNoticeByCategory(int categoryId);
	public List<Category> getCategories();
}

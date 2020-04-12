package kr.or.skhu.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.skhu.news.dao.CategoryDao;
import kr.or.skhu.news.dao.NoticeDao;
import kr.or.skhu.news.dto.Category;
import kr.or.skhu.news.dto.Notice;
import kr.or.skhu.news.service.NoticeService;

// NoticeService 구현 class
@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;

	@Autowired
	CategoryDao categoryDao;

	// notice list를 return
	@Override
	@Transactional
	public List<Notice> getNotices() {
		List<Notice> noticeList = noticeDao.selectAll();
		return noticeList;
	}

	// category 별 list를 return
	@Override
	@Transactional
	public List<Notice> getNoticeByCategory(int categoryId) {
		List<Notice> noticeByCategoryList = noticeDao.selectByCategory(categoryId);
		return noticeByCategoryList;
	}

	// category list를 return
	@Override
	@Transactional
	public List<Category> getCategories() {
		List<Category> categoryList = categoryDao.selectAll();
		return categoryList;
	}
}



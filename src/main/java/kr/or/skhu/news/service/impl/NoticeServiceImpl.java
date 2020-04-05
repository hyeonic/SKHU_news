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

	// category list를 return
	@Override
	@Transactional
	public List<Category> getCategories() {
		List<Category> categoryList = categoryDao.selectAll();
		return categoryList;
	}

	// insert를 위한 service 진행 중
	@Override
	@Transactional(readOnly = false)
	public int insertNotice(List<Notice> noticeList) {


		return 0;
	}

}

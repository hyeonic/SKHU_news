package kr.or.skhu.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.skhu.news.dao.UserInfoDao;
import kr.or.skhu.news.dto.UserInfo;
import kr.or.skhu.news.service.UserInfoService;

// UserInfoService 구현 class
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoDao userInfoDao;

	// userInfo list를 return
	@Override
	@Transactional
	public List<UserInfo> getUserInfo() {
		List<UserInfo> userInfoList = userInfoDao.selectAll();
		return userInfoList;
	}

	// userInfo list를 가져와 비교해본 후 맞다면 true, 다르다면 false를 반환
	@Override
	@Transactional
	public boolean compareUser(UserInfo userInfo) {
		return false;
	}

	// 회원정보를 입력받고 insert 후 정상적으로 입력되었다면 0을 return
	@Override
	@Transactional(readOnly = false)
	public int signUp(UserInfo userInfo) {

		return 0;
	}

}

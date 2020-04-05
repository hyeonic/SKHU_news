package kr.or.skhu.news.service;

import java.util.List;

import kr.or.skhu.news.dto.UserInfo;

public interface UserInfoService {
	public List<UserInfo> getUserInfo();
	public boolean compareUser(UserInfo userInfo);
	public int signUp(UserInfo userInfo);
}

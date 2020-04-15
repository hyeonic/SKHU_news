package kr.or.skhu.news.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.skhu.news.dto.UserInfo;

@Service
public interface UserInfoService {
	public List<UserInfo> getUserInfo();
	public boolean compareUser(UserInfo userInfo);
	public int signUp(UserInfo userInfo);
	public boolean isUserExist(UserInfo userInfo);
}

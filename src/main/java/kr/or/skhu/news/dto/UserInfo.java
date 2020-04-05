package kr.or.skhu.news.dto;

import java.util.Date;

// UserInfoDto class, userInfo의 항목을 저장하는 javaBeans, toString 메서드만 override 해둠
public class UserInfo {
	private int id;
	private String userId;
	private String userPassword;
	private String userName;
	private Date createDate;

	public UserInfo(int id, String userId, String userPassword, String userName, Date createDate) {
		this.id = id;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", createDate=" + createDate + "]";
	}
}

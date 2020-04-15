package kr.or.skhu.news.dao;

// 필요한 sql문을 상수 형태로 저장
public class UserInfoDaoSqls {
	public static final String SELECT_ALL = "SELECT id, user_id, user_password, user_name, create_date "
										  + "FROM user_info; ";

	protected static final String FIND_BY_ID =  "SELECT EXISTS (select * "
											  + "				 FROM `user_info` "
											  + "			     WHERE `user_id` = :userId); ";

}

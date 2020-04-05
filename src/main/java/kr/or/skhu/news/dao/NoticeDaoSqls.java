package kr.or.skhu.news.dao;

// 필요한 sql문을 상수 형태로 저장
public class NoticeDaoSqls {
	public static final String SELECT_ALL = "SELECT id, category_id, notice_title, notice_href, notice_writer, create_date, view_count "
										  + "FROM notice; ";
}

package kr.or.skhu.news.dao;

// 필요한 sql문을 상수 형태로 저장
public class NoticeDaoSqls {
	public static final String SELECT_ALL = "SELECT id, idx, category_id, notice_title, notice_href, notice_writer, create_date, view_count "
										  + "FROM notice; ";

	public static final String SELECT_BY_CATEGORY = "SELECT id, idx, category_id, notice_title, notice_href, notice_writer, create_date, view_count "
												  + "FROM notice "
												  + "WHERE category_id = :categoryId; ";

	public static final String FIND_BY_IDX = "SELECT EXISTS (select * "
										   + "				 FROM notice "
										   + "			     WHERE idx = :idx) as searchResult; ";

	public static final String SELECT_COUNT = "SELECT count(*) "
											+ "FROM notice; ";

}

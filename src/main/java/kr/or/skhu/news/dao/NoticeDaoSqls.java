package kr.or.skhu.news.dao;

// 필요한 sql문을 상수 형태로 저장
public class NoticeDaoSqls {
	public static final String SELECT_ALL = "SELECT idx, notice_title "
										  + "FROM notice "
										  + "order by create_date DESC; ";

	public static final String SELECT_BY_CATEGORY = "SELECT idx, notice_title, "
												  + "FROM notice "
												  + "WHERE category_id = :categoryId "
												  + "order by create_date DESC ; ";

	public static final String FIND_BY_IDX = "SELECT EXISTS (select * "
										   + "				 FROM notice "
										   + "			     WHERE idx = :idx) as searchResult; ";

	public static final String SELECT_COUNT = "SELECT count(*) "
											+ "FROM notice; ";

}

package kr.or.skhu.news.dao;

public class NoticeDetailDaoSqls {
	public static final String FIND_BY_IDX = "SELECT html "
										   + "FROM notice_detail "
										   + "WHERE idx = :idx; ";
}

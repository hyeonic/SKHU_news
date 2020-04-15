package kr.or.skhu.news.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.skhu.news.dto.NoticeDetail;

@Repository
public class NoticeDetailDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<NoticeDetail> rowMapper = BeanPropertyRowMapper.newInstance(NoticeDetail.class);

	public NoticeDetailDao(DataSource dataSource) { // dataSource를 통하여 connection
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("notice_detail")
				.usingGeneratedKeyColumns("id"); // insert를 사용하기 위한 부분 따로 sql문을 선언할 필요 없다.
	}

	public Long insert(NoticeDetail noticeDetail) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(noticeDetail); // DB column에 맞추어 자동으로 insert 해줌
		return insertAction.executeAndReturnKey(params).longValue();
	}
}

package kr.or.skhu.news.dao;

import static kr.or.skhu.news.dao.NoticeDaoSqls.SELECT_ALL;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.skhu.news.dto.Notice;

// NoticeDao
@Repository
public class NoticeDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Notice> rowMapper = BeanPropertyRowMapper.newInstance(Notice.class);

	public NoticeDao(DataSource dataSource) { // dataSource를 통하여 connection
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("notice"); // insert를 사용하기 위한 부분 따로 sql문을 선언할 필요 없다.
	}

	public List<Notice> selectAll() {
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}

	public Long insert(Notice notice) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(notice); // DB column에 맞추어 자동으로 insert 해줌
		return insertAction.executeAndReturnKey(params).longValue();
	}
}

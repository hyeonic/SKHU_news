package kr.or.skhu.news.dao;

import static kr.or.skhu.news.dao.NoticeDaoSqls.FIND_BY_IDX;
import static kr.or.skhu.news.dao.UserInfoDaoSqls.SELECT_ALL;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.skhu.news.dto.UserInfo;

//UserInfoDao
@Repository
public class UserInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<UserInfo> rowMapper = BeanPropertyRowMapper.newInstance(UserInfo.class);

	public UserInfoDao(DataSource dataSource) { // dataSource를 통하여 connection
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
								.withTableName("user_info")
								.usingGeneratedKeyColumns("id")
								.usingGeneratedKeyColumns("create_date"); // insert를 사용하기 위한 부분 따로 sql문을 선언할 필요 없다.
	}

	public List<UserInfo> selectAll() {
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}

	public int insert(UserInfo userInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(userInfo); // DB column에 맞추어 자동으로 insert 해줌
		return insertAction.execute(params);
	}
	
	public int findByIdx(String userId) {
		Map<String, ?> params = Collections.singletonMap("userId", userId);
		return jdbc.queryForObject(FIND_BY_IDX, params, Integer.class);
	}
}

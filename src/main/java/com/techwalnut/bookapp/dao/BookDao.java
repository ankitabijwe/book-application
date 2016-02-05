package com.techwalnut.bookapp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techwalnut.bookapp.vo.BookVO;
import com.techwalnut.bookapp.vo.PreviewVO;

@Repository
public class BookDao {

	protected JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;


	public List<PreviewVO> showAllBooks() {
		List<PreviewVO> bookVO = null;
		try {
			String sql = "select * from book_data order by id desc";
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			bookVO = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<PreviewVO>(PreviewVO.class));
			if (bookVO != null)
				return bookVO;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return bookVO;
	}

}

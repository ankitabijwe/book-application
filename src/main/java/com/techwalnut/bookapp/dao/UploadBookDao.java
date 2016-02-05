package com.techwalnut.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.techwalnut.bookapp.vo.BookVO;
@Repository
public class UploadBookDao {

	protected JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	public boolean saveBookData(final BookVO bookVO) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		final String sql = "Insert into book_data(file,book_image,book_name,book_author,email) values(?,?,?,?,?)";
		int row = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, bookVO.getFile().getOriginalFilename());
				ps.setString(2, bookVO.getBookImage().getOriginalFilename());
				ps.setString(3, bookVO.getBookName());
				ps.setString(4, bookVO.getBookAuthor());
				ps.setString(5, bookVO.getEmail());
				return ps;
			}
		});
		if (row > 0) {
			System.out.println("Success");
			return true;
		}
		return false;
	}

}

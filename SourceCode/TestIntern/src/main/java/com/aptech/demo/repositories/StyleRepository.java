package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Style;


@Repository
public class StyleRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class StyleRowMapper implements RowMapper<Style> {
		@Override
		public Style mapRow(ResultSet rs, int rowNum) throws SQLException {
			Style item = new Style();
			item.setId(rs.getLong("Id"));
			item.setName(rs.getString("Name"));
			return item;
		}
	}

	public List<Style> getAll() {

		return jdbcTemplate.query("SELECT * FROM  styles", new StyleRowMapper());

	}

	public int saveStyle(Style style) {
		return jdbcTemplate.update("INSERT INTO styles (Name) VALUES (?)", new Object[] { style.getName() });
	}
	
	public Style findById(Long id){
        try {
            return jdbcTemplate.queryForObject("select  * from styles where id = ?", new StyleRowMapper(), new Object[]{id});
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

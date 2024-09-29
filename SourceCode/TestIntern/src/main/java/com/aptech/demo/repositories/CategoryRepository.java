package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Category;

@Repository
public class CategoryRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class CategoryRowMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category item = new Category();
			item.setId(rs.getLong("Id"));
			item.setName(rs.getString("Name"));
			return item;
		}
	}

	public List<Category> getAll() {

		return jdbcTemplate.query("SELECT * FROM  Categories", new CategoryRowMapper());

	}
	
	public int saveCategory(Category category) {
		return jdbcTemplate.update("INSERT INTO categories (Name) VALUES (?)", new Object[] {  category.getName() });
	}
	
	public Category findById(Long id){
        try {
            return jdbcTemplate.queryForObject("select  * from categories where id = ?", new CategoryRowMapper(), new Object[]{id});
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

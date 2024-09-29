package com.aptech.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aptech.demo.models.Category;
import com.aptech.demo.models.Product;
import com.aptech.demo.models.Style;

@Repository
public class ProductRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product item = new Product();
			item.setId(rs.getLong("Id"));
			item.setName(rs.getString("Name"));
			item.setDescription(rs.getString("Description"));
			item.setPrice(rs.getDouble("Price"));
			item.setImageName(rs.getString("Image"));
			item.setImg1(rs.getString("Img1"));
			item.setImg2(rs.getString("Img2"));
			item.setImg3(rs.getString("Img3"));

			// Set category
			Category category = new Category();
			category.setName(rs.getString("CategoryName"));
			category.setId(rs.getLong("CategoryId"));
			item.setCategory(category);

			// Set style
			Style style = new Style();
			style.setName(rs.getString("StyleName"));
			style.setId(rs.getLong("styleId"));
			item.setStyle(style);

			return item;
		}
	}

	public List<Product> getAll() {

		return jdbcTemplate.query("SELECT prod.id, prod.name, prod.price, prod.Description, prod.Image, prod.img1, prod.img2, prod.img3, prod.CategoryId, cate.Name as CategoryName, prod.StyleId, sty.Name as StyleName FROM  Products prod inner join categories cate on prod.CategoryId = cate.id inner join Styles sty on prod.styleId = sty.id ", new ProductRowMapper());

	}

	public int savePro(Product product) {
		return jdbcTemplate.update(
				"INSERT INTO products (name, price, description, image, img1, img2, img3, CategoryId, StyleId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { product.getName(), product.getPrice(), product.getDescription(), product.getImageName(),
						product.getImg1(), product.getImg2(), product.getImg3(), product.getCategory().getId(),
						product.getStyle().getId() });
	}

	public Product getProductById(Long id) {

		return jdbcTemplate.queryForObject(
				"SELECT p.*, c.name AS CategoryName, s.name AS StyleName FROM products p "
						+ "LEFT JOIN categories c ON p.CategoryId = c.id "
						+ "LEFT JOIN styles s ON p.StyleId = s.id WHERE p.id = ?",
				new ProductRowMapper(), new Object[] { id });

	}

	public List<Product> getProductByCate(Long id) {
		try {
			return jdbcTemplate.query("SELECT prod.id, prod.name, prod.price, prod.Description, prod.Image, prod.img1, prod.img2, prod.img3, prod.CategoryId, cate.Name as CategoryName, prod.StyleId, sty.Name as StyleName FROM  Products prod inner join categories cate on prod.CategoryId = cate.id inner join Styles sty on prod.styleId = sty.id where cate.Id = ?", new ProductRowMapper(), new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getProductByStyle(Long id) {
		try {
			return jdbcTemplate.query("SELECT prod.id, prod.name, prod.price, prod.Description, prod.Image, prod.img1, prod.img2, prod.img3, prod.CategoryId, cate.Name as CategoryName, prod.StyleId, sty.Name as StyleName FROM  Products prod inner join categories cate on prod.CategoryId = cate.id inner join Styles sty on prod.styleId = sty.id where sty.Id = ?", new ProductRowMapper(), new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

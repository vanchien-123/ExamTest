package com.aptech.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aptech.demo.models.Category;
import com.aptech.demo.repositories.CategoryRepository;

@RestController()
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryRepository cateRepo; 
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Category> getAll(){
		return cateRepo.getAll();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int save(@Validated @RequestBody Category category) {
		
		return cateRepo.saveCategory(category);
		
	}
}

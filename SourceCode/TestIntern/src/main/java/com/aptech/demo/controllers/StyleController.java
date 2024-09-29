package com.aptech.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aptech.demo.models.Style;
import com.aptech.demo.repositories.StyleRepository;

@RestController()
@RequestMapping("/api/style")
public class StyleController {

	@Autowired
	private StyleRepository styleRepo;
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Style> getAll(){
		return styleRepo.getAll();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int save(@Validated @RequestBody Style style) {
		
		return styleRepo.saveStyle(style);
		
	}
	
}

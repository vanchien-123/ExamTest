package com.aptech.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aptech.demo.models.Product;
import com.aptech.demo.repositories.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductRepository proRepo;

	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Product> getAll() {
		return proRepo.getAll();
	}

	@CrossOrigin
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int save(@Validated @RequestBody Product product) {
			
		proRepo.savePro(product);

		return 0;

	}

	@CrossOrigin
	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Product getProductDetail(@PathVariable Long id) {
		// 
		Product product = proRepo.getProductById(id);
		return product;
	}

	@CrossOrigin
	@RequestMapping(value = "/getprobycate/{id}", method = RequestMethod.GET)
	public List<Product> getProductByCate(@PathVariable Long id) {
		List<Product> listProduct = proRepo.getProductByCate(id);
		return listProduct;
	}

	@CrossOrigin
	@RequestMapping(value = "/getprobystyle/{id}", method = RequestMethod.GET)
	public List<Product> getProductByStyle(@PathVariable Long id) {
		List<Product> listProduct = proRepo.getProductByStyle(id);
		return listProduct;
	}

}

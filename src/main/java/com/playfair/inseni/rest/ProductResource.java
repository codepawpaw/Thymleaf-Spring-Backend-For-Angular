package com.playfair.inseni.rest;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.playfair.inseni.model.Product;
import com.playfair.inseni.service.ProductService;

@RestController
@RequestMapping("/meetsup")
public class ProductResource {
	
	@Inject
    private ProductService productService;
	
	/**
	   * Get all product data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/data/product/all",
  		method = RequestMethod.GET,
  		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAll() {
		return productService.findAll();
	}
	
	/**
	   * Get all product data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/data/product/by/userid/{userid}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findByUserId(@PathVariable String userid) {
		return productService.findProductByUserId(userid);
	}
	
	/**
	   * Get all product data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/data/product/by/username/{username}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findByUserName(@PathVariable String username) {
		return productService.findProductByUserName(username);
	}
	
	/**
	   * Save product data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/data/product/save/{title}/{description}/{content}/{userName}/{userid}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean save(@PathVariable String title, @PathVariable String description, @PathVariable String content, @PathVariable String userName, @PathVariable String userid) {
		Product product = new Product(title, description, content, userName);
		product.setUserId(userid);
		return productService.save(product);
	}
	
	/**
	   * Save product data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/data/product/addLike/{productId}/{userId}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean addLike(@PathVariable String productId, @PathVariable String userId) {
		return productService.addLike(productId, userId);
	}
	
	/**
	   * Delete product data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/data/product/delete/{productId}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean delete(@PathVariable String productId) {
		return productService.delete(productId);
	}
  
  

}

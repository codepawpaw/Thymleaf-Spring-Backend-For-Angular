package com.playfair.inseni.service;

import java.util.List;

import com.playfair.inseni.model.Product;

public interface ProductService {
	/**
	   * This method will call mongodb command in product repository
	   */
	public List<Product> findAll();
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public boolean save(Product product);
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public boolean update(String _id, String title, String content, String description);
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public boolean addLike(String productId, String userId);
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public boolean delete(String productId);
	
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public List<Product> findProductByUserName(String useremail);
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public List<Product> findProductByUserId(String userId);
}

package com.playfair.inseni.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.playfair.inseni.model.Product;
import com.playfair.inseni.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Inject
	private ProductRepository productRepository;
	
	/**
	   * This metheod will call mongodb command in product repository
	   */
	public List<Product> findAll(){
		Query query = new Query();
		query.limit(100);
		query.with(new Sort(Sort.Direction.DESC, "_id"));
		//return productRepository.findAll();
		return productRepository.findAll(new Sort(Sort.Direction.DESC, "_id"));
	}
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public List<Product> findProductByUserId(String userId){
		return productRepository.findByUserId(userId);
	}
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public List<Product> findProductByUserName(String useremail){
		return productRepository.findByUserName(useremail);
	}
	
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public boolean save(Product product){
		try{
			productRepository.insert(product);
		} catch(Exception e){
			return false;
		}
		return true;
	}
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public boolean update(String _id, String title, String content, String description){
		try{
			Product product = productRepository.findOne(_id);
			product.setContent(content);
			product.setDescription(description);
			product.setTitle(title);
			productRepository.save(product);
		} catch(Exception e){
			return false;
		}
		return true;
	}
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public boolean addLike(String productId, String userId){
		try{
			Product product = productRepository.findOne(productId);
			product.addLike(userId);
			productRepository.save(product);
		} catch(Exception e){
			return false;
		}
		return true;
	}
	
	/**
	   * This method will call mongodb command in product repository
	   */
	public boolean delete(String productId){
		try{
			productRepository.delete(productId);
			/*Product product = productRepository.findOne(productId);
			productRepository.delete(product);*/
		} catch(Exception e){
			return false;
		}
		return true;
	}
}

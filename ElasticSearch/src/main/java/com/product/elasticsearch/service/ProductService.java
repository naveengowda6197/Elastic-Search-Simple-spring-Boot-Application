package com.product.elasticsearch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.elasticsearch.entity.Product;
import com.product.elasticsearch.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getAll(){
		return productRepository.findAll();
	}
	
	public Product save(Product product){
		return productRepository.save(product);
	}
	
	public Product update(Product product,String id){
		Optional<Product> prod=productRepository.findById( id);
		if(prod.isPresent()) {
			Product p=prod.get();
			p.setName(product.getName());
			p.setManufacturer(product.getManufacturer());
			p.setPrice(product.getPrice());
			p.setDescription(product.getDescription());
			return productRepository.save(p);
		}
		return null;
	}
	
	public boolean delete(String name){
		Product product=productRepository.findByName(name);
		if(product!=null) {
			productRepository.deleteByName(name);
			return true;
		}else {
			return false;
		}
	}
	
}

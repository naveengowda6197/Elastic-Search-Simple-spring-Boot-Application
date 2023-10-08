package com.product.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.product.elasticsearch.entity.Product;


public interface ProductRepository extends ElasticsearchRepository<Product, String> {


	void deleteByName(String name);

	Product findByName(String name);

	
}

package com.product.elasticsearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.elasticsearch.entity.Product;
import com.product.elasticsearch.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> getProducts(){
		Iterable<Product> products=productService.getAll();
		List<Product> list=new ArrayList<>(); 
		
		products.forEach(p->list.add(p));
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product){
		Product p=productService.save(product);
		return new ResponseEntity<Product>(p,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable String id){
		Product p=productService.update(product,id);
		if(p!=null)
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		else
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/delete/{name}")
	public ResponseEntity<Product> delete(@PathVariable String name){
		Boolean p=productService.delete(name);
		if(p==true)
			return new ResponseEntity<Product>(HttpStatus.OK);
		else
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
}

package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.exception.ProductServiceException;
import com.rest.model.ProductRequest;
import com.rest.model.ProductResponse;
import com.rest.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	 private ProductService productService;
	@PostMapping("/add")
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
		Long ProductId=productService.addProduct(productRequest);
		return new ResponseEntity<>(ProductId,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable("id")Long productId) throws ProductServiceException{
		ProductResponse response=productService.getProductId(productId);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable ("id") Long ProductId,@RequestParam int quantity) throws ProductServiceException{
		productService.reduceQuantity(ProductId,quantity);
		return new  ResponseEntity<Void>(HttpStatus.OK);
	}
}


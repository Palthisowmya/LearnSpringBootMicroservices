package com.rest.service;

import com.rest.exception.ProductServiceException;
import com.rest.model.ProductRequest;
import com.rest.model.ProductResponse;

public interface ProductService {

	Long addProduct(ProductRequest productRequest);

	ProductResponse getProductId(Long productId) throws ProductServiceException;

	void reduceQuantity(Long productId, int quantity)throws ProductServiceException;

}

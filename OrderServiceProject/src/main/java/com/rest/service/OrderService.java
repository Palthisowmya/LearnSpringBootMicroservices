package com.rest.service;

import com.rest.model.OrderRequest;

public interface OrderService {

	Long placeOrder(OrderRequest orderRequest);

}

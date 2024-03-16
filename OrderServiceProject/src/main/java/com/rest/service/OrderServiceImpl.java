package com.rest.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.client.ProductService;
import com.rest.entity.Order;
import com.rest.model.OrderRequest;
import com.rest.repo.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderRepository orderRepository;
  
  @Autowired
  private ProductService productService;
  
  @Override
	public Long placeOrder(OrderRequest orderRequest) {
	  log.info("before placing order");
	  productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
	  log.info("After checking product avalibility for the product"+orderRequest.getProductId());
	  Order order=Order.builder()
    		   .ProductId(orderRequest.getProductId())
    		   .price(orderRequest.getAmount())
    		   .orderDate(Instant.now())
    		   .orderStatus("created")
    		   .quantity(orderRequest.getQuantity())
    		   .build();
	  log.info("order placed");
      order= orderRepository.save(order);
      log.info("product Saved successfully after placing order");
	  return order.getOrderId();
	}

}

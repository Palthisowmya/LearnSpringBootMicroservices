package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.OrderRequest;
import com.rest.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
@Autowired
private OrderService orderService;
@PostMapping("/placeOrder")
public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
	Long OrderId=orderService.placeOrder(orderRequest);
	return new ResponseEntity<>(OrderId,HttpStatus.OK);
}
}

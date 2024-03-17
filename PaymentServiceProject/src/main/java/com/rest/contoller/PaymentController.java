package com.rest.contoller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.model.PaymentRequest;
import com.rest.model.PaymentResponse;
import com.rest.service.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {
   @Autowired
	private PaymentService paymentService;
   
   @PostMapping("/doPayment")
   public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
		Long PaymentId=paymentService.doPayment(paymentRequest);
		return new ResponseEntity<>(PaymentId,HttpStatus.OK); 
	}
   @GetMapping("/{orderId}")
	public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable Long orderId){
	   PaymentResponse paymentResponse=paymentService.getPaymentDetails(orderId);
		return new ResponseEntity<>(paymentResponse,HttpStatus.OK);
	}
}

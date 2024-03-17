package com.rest.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.PaymentDetails;
import com.rest.model.PaymentMode;
import com.rest.model.PaymentRequest;
import com.rest.model.PaymentResponse;
import com.rest.repo.PaymentServiceRepository;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentServiceRepository paymentServiceRepository;
	
	@Override
	public Long doPayment(PaymentRequest paymentRequest) {
		log.info("PaymentRequest in PaymentRequestImpl ::"+paymentRequest);
		PaymentDetails paymentDetails=PaymentDetails.builder()
				.amount(paymentRequest.getAmount())
				.paymentDate(Instant.now())
				.paymentMode(paymentRequest.getPaymentMode().name())
				 //.paymentMode(paymentModeName)
				.paymentStatus("Success")
				.orderId(paymentRequest.getOrderId())
				.build();
		log.info("paymentDetails in doPayment"+paymentDetails);
		paymentServiceRepository.save(paymentDetails); 
		return paymentDetails.getPaymentId();
	}

	@Override
	public PaymentResponse getPaymentDetails(Long orderId) {
		// TODO Auto-generated method stub
		PaymentDetails paymentDetails=paymentServiceRepository.findByOrderId(orderId);
		PaymentResponse paymentResponse=PaymentResponse.builder()
				.amount(paymentDetails.getAmount())
				.orderId(paymentDetails.getOrderId())
				.paymentDate(paymentDetails.getPaymentDate())
				.paymentId(paymentDetails.getPaymentId())
				.status(paymentDetails.getPaymentStatus())
				.paymentMode(PaymentMode.valueOf(paymentDetails.getPaymentMode()))
				.build();
		return paymentResponse;
	}

}

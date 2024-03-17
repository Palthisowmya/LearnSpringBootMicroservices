package com.rest.service;


import com.rest.model.PaymentRequest;
import com.rest.model.PaymentResponse;

public interface PaymentService {

	Long doPayment(PaymentRequest paymentRequest);

	PaymentResponse getPaymentDetails(Long orderId);

}

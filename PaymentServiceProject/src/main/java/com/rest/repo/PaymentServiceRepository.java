package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entity.PaymentDetails;


public interface PaymentServiceRepository extends JpaRepository<PaymentDetails, Long> {

	PaymentDetails findByOrderId(Long orderId);

}

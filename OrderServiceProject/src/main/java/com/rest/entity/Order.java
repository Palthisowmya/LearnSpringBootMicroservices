package com.rest.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="order_table")
public class Order {
	 @Id
	 @GeneratedValue(strategy =GenerationType.AUTO)
  private Long OrderId;
  private Long ProductId;
  private Double price;
  private Instant orderDate;
  private String orderStatus;
  private int quantity;
  
}

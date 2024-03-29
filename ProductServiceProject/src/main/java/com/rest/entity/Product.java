package com.rest.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
	
 @Id
 @GeneratedValue(strategy =GenerationType.AUTO)
  private Long productId;
  private String productName;
  private double price;
  private int quantity;
}

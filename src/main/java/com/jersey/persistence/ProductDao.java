package com.jersey.persistence;

import com.jersey.representations.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDao extends JpaRepository<Product, Long> {
}

package com.jersey.persistance;

import com.jersey.representations.Products;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDao extends JpaRepository<Products, Long> {
}

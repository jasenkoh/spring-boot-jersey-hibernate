package com.jersey.persistance;

import com.jersey.entity.daoEntity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDao extends JpaRepository<ProductEntity, Long> {
}

package com.jersey.services;

import com.google.common.collect.Lists;
import com.jersey.entity.boEntity.Product;
import com.jersey.entity.daoEntity.ProductEntity;
import com.jersey.persistance.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductsService {
    private ProductDao productDao;
    @Autowired
    public ProductsService(ProductDao productDao){
        this.productDao = productDao;
    }

    public List<Product> getAll(){
        return Lists.transform(this.productDao.findAll(), Product.productTransform());
    }

    public Product getOne(long id) {
        Product product = new Product(productDao.findOne(id));
        return product;
    }

    public Product save(Product product) {
        ProductEntity productEntity = productDao.save(new ProductEntity(product));
        return new Product(productEntity);
    }

    public Product update(long id, Product product) {
        ProductEntity productEntity = productDao.save(new ProductEntity(product));
        return new Product(productDao.save(productEntity));
    }

    public void delete(long id) {
        ProductEntity productEntity = productDao.findOne(id);
        productDao.delete(productEntity);
    }
}
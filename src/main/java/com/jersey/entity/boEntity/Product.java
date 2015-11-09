package com.jersey.entity.boEntity;

import com.google.common.base.Function;
import com.jersey.entity.daoEntity.ProductEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Product {
    private Long id;
    private String name;
    private String currency;
    private Double regularPrice;
    private Double discountPrice;
    private Long memberId;

    public Product() {
    }

    public Product(Long id, String name, String currency, Double regularPrice, Double discountPrice,long memberId) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.regularPrice = regularPrice;
        this.discountPrice = discountPrice;
        this.memberId = memberId;
    }

    public Product(ProductEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.currency = entity.getCurrency();
        this.regularPrice = entity.getRegularPrice();
        this.discountPrice = entity.getDiscountPrice();
        this.memberId = entity.getMember_id();
    }

    public static Function<ProductEntity,Product> productTransform() {
        return new Function<ProductEntity, Product>() {
            public Product apply(ProductEntity entity) {
                return new Product(entity);
            }
        };
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(Double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}

package com.jersey.entity.daoEntity;

import com.jersey.entity.boEntity.Product;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String currency;
    @Column(name = "regular_price")
    @NotNull
    private Double regularPrice;
    @Column(name = "discount_price")
    @NotNull
    private Double discountPrice;

    @JoinColumn(name = "member_id")
    @NotNull
    private Long member_id;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String currency, Double regularPrice, Double discountPrice) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.regularPrice = regularPrice;
        this.discountPrice = discountPrice;
    }

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.currency = product.getCurrency();
        this.regularPrice = product.getRegularPrice();
        this.discountPrice = product.getDiscountPrice();
        this.member_id = product.getMemberId();
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

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }
}

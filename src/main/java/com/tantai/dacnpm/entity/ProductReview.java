package com.tantai.dacnpm.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_review")
public class ProductReview extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

}

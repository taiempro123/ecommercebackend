package com.tantai.dacnpm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem extends BaseEntity{

    @Column(name = "price",nullable = false, precision = 10, scale = 2)
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "quantity",nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

}

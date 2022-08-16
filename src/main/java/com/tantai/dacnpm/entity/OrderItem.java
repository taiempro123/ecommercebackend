package com.tantai.dacnpm.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity{

    @Column(nullable = false, precision = 10, scale = 2)
    private double price;

    @Column()
    private double discount;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

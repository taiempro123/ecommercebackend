package com.tantai.dacnpm.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class Order extends BaseEntity{

    @Column( name = "name",nullable = false, length = 35)
    private String name;

    @Column(name = "total",nullable = false, precision = 10, scale = 2)
    private double total;

    @Column(name = "status",nullable = false)
    private int status;

    @Column(name = "discount",nullable = false, precision = 10, scale = 2)
    private double discount;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "line",nullable = false)
    private String line;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orders", nullable = false)
    @JsonIgnore
    private User user;



}

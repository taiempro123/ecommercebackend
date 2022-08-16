package com.tantai.dacnpm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product extends BaseEntity {
    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 4000)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private double price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date addedOn = new Date();

    @Lob
    @Column(nullable = true, length = Integer.MAX_VALUE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private byte[] image;

    @Column()
    private double discount;

    @Column(nullable = false)
    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date startsAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date endsAt;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductReview> productRivews = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "product_category",
            joinColumns = {
                    @JoinColumn(name = "product_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id")})
    private List<Category> categories;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "product_tag",
            joinColumns = {
                    @JoinColumn(name = "product_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "tag_id")})
    private List<Tag> tags;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "products", nullable = false)
    @JsonIgnore
    private User user;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> orderItems = new ArrayList<>();

}

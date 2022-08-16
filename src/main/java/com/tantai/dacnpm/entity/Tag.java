package com.tantai.dacnpm.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag")
public class Tag extends BaseEntity{
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToMany(mappedBy = "tags")
    private List<Product> products = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

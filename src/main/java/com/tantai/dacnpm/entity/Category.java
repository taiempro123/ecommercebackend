package com.tantai.dacnpm.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends BaseEntity{

    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 100)
    private String slug;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}

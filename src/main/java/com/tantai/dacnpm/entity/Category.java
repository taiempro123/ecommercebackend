package com.tantai.dacnpm.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category extends BaseEntity{

    @Column(name = "title",nullable = false, length = 100)
    private String title;

    @Column(name = "slug", length = 100)
    private String slug;

    @Column(name = "content", length = 100)
    private String content;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

}

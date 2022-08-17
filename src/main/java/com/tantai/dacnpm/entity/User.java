package com.tantai.dacnpm.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "user")
public class User extends BaseEntity{
    @Column(name = "user_name",unique = true, nullable = false, length = 35)
    private String userName;

    @Column(name = "password",nullable = false, length = 128)
    private String password;

    @Column(name = "email",unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "name",nullable = false, length = 100)
    private String name;

    @Column(name = "address",nullable = false, length = 128)
    private String address;

    @Column(name = "phone",nullable = false, length = 15)
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "role_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Order> orders = new ArrayList<>();

    public User(String userName, String password, String email, String name, String address, String phone) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}

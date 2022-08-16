package com.tantai.dacnpm.entity;


import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(name = "name", nullable = true, unique = true)
    private String name;


    @Column(name = "deleted_name")
    private String deletedName;

    @Column(name = "initials", nullable = true, unique = true)
    private String initials;


    @Column(name = "deleted_initials")
    private String deletedInitials;


    @Column(nullable = true, unique = true)
    private String description;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },
//            mappedBy = "roles")
//    private List<User> User = new ArrayList<>();

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeletedName() {
        return deletedName;
    }

    public void setDeletedName(String deletedName) {
        this.deletedName = deletedName;
    }

    public String getDeletedInitials() {
        return deletedInitials;
    }

    public void setDeletedInitials(String deletedInitials) {
        this.deletedInitials = deletedInitials;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Role)) {
            return false;
        }
        Role role = (Role) object;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
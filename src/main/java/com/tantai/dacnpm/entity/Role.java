package com.tantai.dacnpm.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "roles")
    private List<User> User = new ArrayList<>();

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
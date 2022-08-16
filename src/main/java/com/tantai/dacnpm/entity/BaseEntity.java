package com.tantai.dacnpm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "created_by", nullable = false)
    protected String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    protected Date createdAt;

    @Column(name = "update_by")
    protected String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    protected Date updatedAt;

}

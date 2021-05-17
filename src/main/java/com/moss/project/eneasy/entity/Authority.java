package com.moss.project.eneasy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Table(schema = "RECOMMEND", name = "AUTHORITY")
@Entity
@Getter
@Setter
public class Authority extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private AuthorityType name;

    public Authority() {}

    public Authority(AuthorityType name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;
}

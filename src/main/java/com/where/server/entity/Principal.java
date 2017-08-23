package com.where.server.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Principal {

    public enum Permission {

        READ,

        WRITE // implies READ
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String username;

    // this must not be stored in clear text, maybe later
    private String password;

    @Enumerated(EnumType.STRING)
    private Permission permission;

    private boolean enabled;
}

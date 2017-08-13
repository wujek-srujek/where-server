package com.where.server.entity;


import java.time.Instant;
import java.time.ZoneId;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.where.server.validation.LocationValidationRules;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@Entity
@Getter
@Setter
public class Location implements LocationValidationRules {

    public enum SaveMode {

        AUTOMATIC,

        MANUAL
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private Instant timestampUtc;

    // Hibernate doesn't natively support ZoneId in the version bundled with Spring Boot
    // so use the converter written by the Spring Data JPA people
    @Convert(converter = Jsr310JpaConverters.ZoneIdConverter.class)
    private ZoneId timeZone;

    private double latitude;

    private double longitude;

    private Double accuracy;

    @Enumerated(EnumType.STRING)
    private SaveMode saveMode;
}

package com.where.server.dto;


import java.time.Instant;
import java.time.ZoneId;

import com.where.server.entity.Location;
import com.where.server.validation.LocationValidationRules;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LocationDto implements LocationValidationRules {

    // format: second.nanosecond
    private Instant timestampUtc;

    private ZoneId timeZone;

    private double latitude;

    private double longitude;

    private Double accuracy;

    private Location.SaveMode saveMode;
}

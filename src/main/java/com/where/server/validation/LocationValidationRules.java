package com.where.server.validation;


import java.time.Instant;
import java.time.ZoneId;

import javax.validation.constraints.NotNull;

import com.where.server.entity.Location;
import org.hibernate.validator.constraints.Range;


// collect validation rules in an interface so that both the entity and dto have the same
public interface LocationValidationRules {

    @NotNull
    Instant getTimestampUtc();

    @NotNull
    ZoneId getTimeZone();

    @Range(min = -90, max = 90)
    double getLatitude();

    @Range(min = -180, max = 180)
    double getLongitude();

    Double getAccuracy();

    @NotNull
    Location.SaveMode getSaveMode();
}

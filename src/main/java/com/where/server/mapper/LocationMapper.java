package com.where.server.mapper;


import java.util.List;
import java.util.stream.Collectors;

import com.where.server.dto.LocationDto;
import com.where.server.entity.Location;
import org.springframework.stereotype.Component;


@Component
public class LocationMapper {

    public Location toEntity(LocationDto dto) {
        Location entity = new Location();
        entity.setTimestampUtc(dto.getTimestampUtc());
        entity.setTimeZone(dto.getTimeZone());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setAccuracy(dto.getAccuracy());
        entity.setSaveMode(dto.getSaveMode());

        return entity;
    }

    public List<Location> toEntities(List<LocationDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public LocationDto toDto(Location entity) {
        LocationDto dto = new LocationDto();
        dto.setTimestampUtc(entity.getTimestampUtc());
        dto.setTimeZone(entity.getTimeZone());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setAccuracy(entity.getAccuracy());
        dto.setSaveMode(entity.getSaveMode());

        return dto;
    }
}

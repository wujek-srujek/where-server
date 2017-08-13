package com.where.server.service;


import java.util.List;
import java.util.Optional;

import com.where.server.dto.LocationDto;
import com.where.server.mapper.LocationMapper;
import com.where.server.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class LocationService {

    private final LocationRepository locationRepository;

    private final LocationMapper locationMapper;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Transactional
    public void save(List<LocationDto> locationDtos) {
        locationRepository.save(locationMapper.toEntities(locationDtos));
    }

    @Transactional(readOnly = true)
    public Optional<LocationDto> getLatest() {
        return locationRepository.findTopByOrderByTimestampUtcDescIdDesc().map(locationMapper::toDto);
    }
}

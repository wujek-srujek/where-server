package com.where.server.repository;


import java.util.List;
import java.util.Optional;

import com.where.server.entity.Location;
import org.springframework.data.repository.Repository;


public interface LocationRepository extends Repository<Location, Long> {

    List<Location> save(Iterable<Location> entities);

    Optional<Location> findTopByOrderByTimestampUtcDescIdDesc();
}

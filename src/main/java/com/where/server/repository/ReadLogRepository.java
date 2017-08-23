package com.where.server.repository;


import com.where.server.entity.ReadLogEntry;
import org.springframework.data.repository.Repository;


public interface ReadLogRepository extends Repository<ReadLogEntry, Long> {

    ReadLogEntry save(ReadLogEntry entity);
}

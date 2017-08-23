package com.where.server.service;


import java.time.Instant;

import com.where.server.entity.ReadLogEntry;
import com.where.server.repository.ReadLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class ReadLogService {

    private final ReadLogRepository readLogRepository;

    @Autowired
    public ReadLogService(ReadLogRepository readLogRepository) {
        this.readLogRepository = readLogRepository;
    }

    // by design, read logs are written asynchronously as they are not necessary for normal operation
    // this also means that a separate transaction must be used, but that's correct anyway as we want
    // them to be saved independently of the read result as it's read intent that should be logged
    @Async
    @Transactional
    public void saveAsync(String username) {
        ReadLogEntry readLogEntry = new ReadLogEntry();
        readLogEntry.setPrincipalUsername(username);
        readLogEntry.setTimestampUtc(Instant.now());
        readLogRepository.save(readLogEntry);
    }
}

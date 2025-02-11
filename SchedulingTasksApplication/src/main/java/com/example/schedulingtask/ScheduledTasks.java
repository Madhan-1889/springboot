package com.example.schedulingtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private String lastExecutionTime;

    @Scheduled(fixedRate = 5000) // Runs every 5 seconds
    public void reportCurrentTime() {
        lastExecutionTime = dateFormat.format(new Date());
        log.info("The time is now {}", lastExecutionTime);
    }

    public String getLastExecutionTime() {
        return lastExecutionTime;
    }
}

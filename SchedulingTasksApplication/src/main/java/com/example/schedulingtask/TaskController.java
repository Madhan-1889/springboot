package com.example.schedulingtask;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final ScheduledTasks scheduledTasks;

    public TaskController(ScheduledTasks scheduledTasks) {
        this.scheduledTasks = scheduledTasks;
    }

    @GetMapping("/time")
    public String getCurrentTime() {
        return "Last execution time: " + scheduledTasks.getLastExecutionTime();
    }
}
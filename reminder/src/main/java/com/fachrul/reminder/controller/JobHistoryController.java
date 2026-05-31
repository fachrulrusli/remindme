package com.fachrul.reminder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.fachrul.reminder.model.entity.JobHistory;
import com.fachrul.reminder.service.JobHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/scheduler/jobs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class JobHistoryController {

    private final JobHistoryService service;

    @GetMapping("/{jobId}/history")
    public List<JobHistory> getHistory(@PathVariable Long jobId) {
        return service.getByJobId(jobId);
    }
}

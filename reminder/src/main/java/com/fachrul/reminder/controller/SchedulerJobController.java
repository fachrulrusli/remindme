package com.fachrul.reminder.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fachrul.reminder.model.entity.SchedulerJob;
import com.fachrul.reminder.repository.SchedulerJobRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/scheduler")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SchedulerJobController {

    private final SchedulerJobRepository repository;

    // ✅ GET ALL JOB
    @GetMapping("/jobs")
    public ResponseEntity<List<SchedulerJob>> getAllJobs() {
        return ResponseEntity.ok(repository.findAll());
    }

    // ✅ GET JOB BY ID
    @GetMapping("/jobs/{id}")
    public ResponseEntity<SchedulerJob> getJobById(@PathVariable Long id) {
        SchedulerJob job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job tidak ditemukan"));
        return ResponseEntity.ok(job);
    }

    // ✅ CREATE JOB
    @PostMapping("/jobs")
    public ResponseEntity<SchedulerJob> createJob(@RequestBody SchedulerJob job) {

        job.setIsActive(true);
        job.setLastRunAt(null);

        SchedulerJob saved = repository.save(job);

        return ResponseEntity.ok(saved);
    }

    // ✅ UPDATE JOB
    @PutMapping("/jobs/{id}")
    public ResponseEntity<SchedulerJob> updateJob(
            @PathVariable Long id,
            @RequestBody SchedulerJob request
    ) {

        SchedulerJob job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job tidak ditemukan"));

        job.setJobName(request.getJobName());
        job.setPrompt(request.getPrompt());
        job.setIntervalSeconds(request.getIntervalSeconds());
        job.setPhoneNumber(request.getPhoneNumber());

        return ResponseEntity.ok(repository.save(job));
    }

    // ✅ DELETE JOB
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    // ✅ TOGGLE ON / OFF
    @PutMapping("/jobs/{id}/toggle")
    public ResponseEntity<SchedulerJob> toggleJob(@PathVariable Long id) {

        SchedulerJob job = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job tidak ditemukan"));

        job.setIsActive(!job.getIsActive());

        return ResponseEntity.ok(repository.save(job));
    }
}

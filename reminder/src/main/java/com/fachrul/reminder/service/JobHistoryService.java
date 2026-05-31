package com.fachrul.reminder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.fachrul.reminder.model.entity.JobHistory;
import com.fachrul.reminder.repository.JobHistoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobHistoryService {

    private final JobHistoryRepository repository;

    public List<JobHistory> getByJobId(Long jobId) {
        return repository.findByJobIdOrderByRunAtDesc(jobId);
    }

    public void save(JobHistory history) {
        repository.save(history);
    }
}
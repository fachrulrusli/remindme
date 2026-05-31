package com.fachrul.reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fachrul.reminder.model.entity.JobHistory;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {

    List<JobHistory> findByJobIdOrderByRunAtDesc(Long jobId);

}
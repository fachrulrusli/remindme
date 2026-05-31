package com.fachrul.reminder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fachrul.reminder.model.entity.SchedulerJob;

@Repository
public interface SchedulerJobRepository extends JpaRepository<SchedulerJob, Long> {
    List<SchedulerJob> findByIsActiveTrue();
}

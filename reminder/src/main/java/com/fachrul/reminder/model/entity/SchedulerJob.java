package com.fachrul.reminder.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "scheduler_job")
@Data
public class SchedulerJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobName;

    @Column(columnDefinition = "TEXT")
    private String prompt;

    private Integer intervalSeconds;

    private String phoneNumber;

    private Boolean isActive;

    private LocalDateTime lastRunAt;
}

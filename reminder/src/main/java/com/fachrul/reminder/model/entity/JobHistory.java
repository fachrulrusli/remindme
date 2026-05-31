package com.fachrul.reminder.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "job_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;

    private String status; // SUCCESS / FAILED

    private String message;

    private LocalDateTime runAt;
}
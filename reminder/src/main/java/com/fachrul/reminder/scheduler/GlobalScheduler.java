package com.fachrul.reminder.scheduler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fachrul.reminder.model.entity.JobHistory;
import com.fachrul.reminder.model.entity.SchedulerJob;
import com.fachrul.reminder.repository.SchedulerJobRepository;
import com.fachrul.reminder.service.AiService;
import com.fachrul.reminder.service.JobHistoryService;
import com.fachrul.reminder.service.WhatsappService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GlobalScheduler {
    private final SchedulerJobRepository jobRepository;
    private final AiService aiService;
    private final WhatsappService whatsappService;
    private final JobHistoryService jobHistoryService;

    @Scheduled(fixedRate = 10000) // cek tiap 10 detik
    public void runJobs() {

            List<SchedulerJob> jobs = jobRepository.findByIsActiveTrue();

            for (SchedulerJob job : jobs) {

                if (shouldRun(job)) {
                    executeJob(job);
                }
        }
    } 

    private boolean shouldRun(SchedulerJob job) {

        if (job.getLastRunAt() == null) return true;

        long seconds = Duration.between(
            job.getLastRunAt(),
            LocalDateTime.now()
        ).getSeconds();

        return seconds >= job.getIntervalSeconds();
    }

    private void executeJob(SchedulerJob job) {

        System.out.println("RUN JOB: " + job.getJobName());

        String result = aiService.generateFromPrompt(job.getPrompt());

        String response = whatsappService.sendMessage(
            job.getPhoneNumber(),
            result
        );

        job.setLastRunAt(LocalDateTime.now());
        jobRepository.save(job);

        String sukses = response.contains("sent") ? "SUCCESS" : "FAILED";
        String msg = response;

        JobHistory history = JobHistory.builder()
            .jobId(job.getId())
            .status(sukses)
            .message(msg)
            .runAt(LocalDateTime.now())
            .build();

        jobHistoryService.save(history);
    }
}

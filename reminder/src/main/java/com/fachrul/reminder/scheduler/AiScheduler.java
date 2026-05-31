package com.fachrul.reminder.scheduler;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fachrul.reminder.service.AiService;
import com.fachrul.reminder.service.WhatsappService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AiScheduler {

    private final AiService aiService;
    private final WhatsappService whatsappService;

    // @Scheduled(cron = "*/10 * * * * *")
    // public void kirimOtomatis() {
    //     whatsappService.sendMessage(
    //         "6281212813679",
    //         "TEST AUTO KIRIM 🚀 " + LocalDateTime.now()
    //     );
    // }

    // @Scheduled(cron = "0 * * * * *")
    // public void sendDailyUpdate() {
    //     String message = aiService.generateMessage();
    //     whatsappService.sendMessage("6281212813679", message); // Replace with actual phone number
    // }

    public void jalan() {

        System.out.println("AMBIL AI 🔥");

        // String berita = aiService.generateNewsAi();
        String berita = null;
        whatsappService.sendMessage(
                "6281212813679",
                "📢 UPDATE SEPAKBOLA HARI INI\n\n" + berita
        );
    }
}

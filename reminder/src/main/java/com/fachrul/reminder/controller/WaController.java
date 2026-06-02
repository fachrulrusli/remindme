package com.fachrul.reminder.controller;

import org.springframework.web.bind.annotation.*;

import com.fachrul.reminder.service.WhatsappService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class WaController {

    private final WhatsappService whatsappService;

    @GetMapping("/wa")
    public String testWA() {
        whatsappService.sendMessage(
                "6281XXXXXXXXXX",
                "Halo dari Spring Boot 🚀"
        );

        return "OK";
    }
}
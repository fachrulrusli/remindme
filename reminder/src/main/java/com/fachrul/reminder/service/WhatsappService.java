package com.fachrul.reminder.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WhatsappService {

    @Value("${wa_server}")
    private String WA_URL;

    public String sendMessage(String number, String message) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, String> body = new HashMap<>();
            body.put("number", number);
            body.put("message", message);

            HttpEntity<Map<String, String>> request =
                    new HttpEntity<>(body, headers);

            String response = restTemplate.postForObject(
                    WA_URL,
                    request,
                    String.class
            );

            System.out.println("WA Response: " + response);
            return response != null ? response : "No response from WA service";
        } catch (Exception e) {
            System.err.println("Gagal kirim WA: " + e.getMessage());
            return "Error occurred while sending WA message";
        }
    }
}
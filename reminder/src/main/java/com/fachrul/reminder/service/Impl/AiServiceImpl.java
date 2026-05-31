package com.fachrul.reminder.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fachrul.reminder.service.AiService;

@Service
public class AiServiceImpl implements AiService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${cloudflare.api.token}")
    private String apiToken;

    @Value("${cloudflare.account.id}")
    private String accountId;

    @Value("${cloudflare.model}")
    private String model;

    @Override
    public String generateFromPrompt(String prompt) {

        String finalPrompt = """
            Buatkan pesan WhatsApp yang rapi dan singkat.

            Aturan:
            - Jika ada daftar, buat dalam bentuk list dengan nomor urut
            - Gunakan bahasa yang santai dan mudah dimengerti
            - Gunakan emoji seperlunya
            - Jangan buat link palsu
            - Gunakan bahasa Indonesia
            - Jangan mengulang kata-kata prompt di dalam pesan

            Topik:
            """ + prompt;

        try {
            Map<String, Object> request = new HashMap<>();

            request.put("model", model);
            request.put("messages", List.of(
                    Map.of("role", "user", "content", finalPrompt)
            ));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiToken);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

            String url = "https://api.cloudflare.com/client/v4/accounts/" + accountId + "/ai/run/" + model;

            ResponseEntity<Map> response = restTemplate.postForEntity(
                    url,
                    entity,
                    Map.class
            );

            if (response.getBody() != null) {

                Map body = response.getBody();
                Map result = (Map) body.get("result");

                if (result != null) {
                    List choices = (List) result.get("choices");

                    if (choices != null && !choices.isEmpty()) {
                        Map firstChoice = (Map) choices.get(0);
                        Map message = (Map) firstChoice.get("message");

                        if (message != null && message.get("content") != null) {
                            return message.get("content").toString();
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Gagal generate AI";
    }
}

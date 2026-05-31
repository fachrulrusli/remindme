package com.fachrul.reminder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Service
public interface AiService {

    String generateFromPrompt(String prompt);


    // @Value("${openai.api.key}")
    // private String apiKey;

    // public String generateMessage() {
    //     return """
    //     ⚽ Update Sepakbola Hari Ini

    //     - MU menang 2-0 atas Chelsea
    //     - Real Madrid beli pemain baru

    //     Sumber:
    //     https://example.com
    //     """;
    // }

    // public String generateNewsAi() {
    //     try {
    //         RestTemplate restTemplate = new RestTemplate();
    //         ObjectMapper mapper = new ObjectMapper();

    //         String url = "http://localhost:11434/api/generate";

    //         Map<String, Object> body = new HashMap<>();
    //         body.put("model", "phi3");
    //         body.put("prompt",
    //                 "Berikan 3 Resep masakan olahan daging sapi atau kambing dengan format:\n" +
    //                 "1. Judul\nLink:\n\n2. Judul\nLink:\n\n3. Judul\nLink:"
    //         );
    //         body.put("stream", false);

    //         String rawResponse = restTemplate.postForObject(url, body, String.class);

    //         // 🔥 PARSING DI SINI
    //         Map result = mapper.readValue(rawResponse, Map.class);

    //         String clean = result.get("response").toString();

    //         return clean;

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return "Gagal parsing AI";
    //     }
    // }
}

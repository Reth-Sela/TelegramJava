package com.example.FinalBackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TelegramController {
    @PostMapping("/sent")

    public ResponseEntity<String> getMessageFromClientSide(@RequestBody Map<String, String> requestBody) {
        String text = requestBody.get("text");
        // Do something with the text value
        Telegrambot telegrambot= new Telegrambot();
        try {
            TelegramBotsApi telegramBotsApi=new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegrambot);
            telegrambot.sendText(1472128065L,text);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Sent Successfully");

    }

}

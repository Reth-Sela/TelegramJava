package com.example.FinalBackend;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Telegrambot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
       return "@selafeedback_bot";
    }

    @Override
    public String getBotToken() {
        return "6839140044:AAH_M6gd-vqWNNghMG3Ph6Sr1EhNzgNebXg";
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendText(1472128065L,"what up bro");


    }

    public void sendText(Long chat_ID, String Text){
        SendMessage sm = SendMessage.builder()
                .chatId(chat_ID.toString()) //Who are we sending a message to
                .text(Text).build();    //Message content
        try {
            execute(sm);//Actually sending the message
            System.out.println(chat_ID+" has been sent ");
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }
}


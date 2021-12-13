package by.itacademy.silina.service;

import by.itacademy.silina.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {

    public Message getStartMessage() {
        return Message.builder()
                .text("Start message: Hi all!")
                .build();
    }

    public Message getModifiedMessage(Message message, String text, int number) {
        //for execution aspect with exception throwing
        number = 1 / number;
        message.setText("End message № " + number + " : Bye all! " + text);
        return message;
    }
}

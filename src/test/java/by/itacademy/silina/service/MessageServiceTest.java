package by.itacademy.silina.service;

import by.itacademy.silina.config.AppConfig;
import by.itacademy.silina.model.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class MessageServiceTest {
    private final Message message = Message.builder().build();
    @Autowired
    private MessageService messageService;

    @Test
    void getStartMessage() {
        Message startMessage = messageService.getStartMessage();
        Assertions.assertEquals("Start message: Hi all!", startMessage.getText());
    }

    @Test
    void getModifiedMessage() {
        Message modifiedMessage = messageService.getModifiedMessage(message, "text", 1);
        Message expectedMessage = Message.builder()
                .text("End message № 1 : Bye all! text")
                .build();
        Assertions.assertEquals(expectedMessage, modifiedMessage);
    }

    @Test
    void getModifiedMessageWithException() {
        Message modifiedMessage = messageService.getModifiedMessage(message, "text", 0);
        Assertions.assertNull(modifiedMessage);
    }
}

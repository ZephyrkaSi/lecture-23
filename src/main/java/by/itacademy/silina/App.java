package by.itacademy.silina;

import by.itacademy.silina.config.AppConfig;
import by.itacademy.silina.model.Message;
import by.itacademy.silina.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService messageService = context.getBean(MessageService.class);

        Message startMessage = messageService.getStartMessage();
        messageService.getModifiedMessage(startMessage, "some_text_1", 1);
        //to throw arithmetic exception
        messageService.getModifiedMessage(startMessage, "some_text_2", 0);
        messageService.getModifiedMessage(startMessage, "some_text_3", 1);

    }
}

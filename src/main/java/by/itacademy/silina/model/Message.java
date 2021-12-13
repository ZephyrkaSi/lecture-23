package by.itacademy.silina.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private String text;

    @Override
    public String toString() {
        return text;
    }
}

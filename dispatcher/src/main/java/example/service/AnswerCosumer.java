package example.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface AnswerCosumer {

    void consume(SendMessage sendMessage);
}

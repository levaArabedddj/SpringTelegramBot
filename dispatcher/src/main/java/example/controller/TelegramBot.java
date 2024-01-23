package example.controller;


import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Component
@Log4j
public class TelegramBot extends TelegramLongPollingBot {


    final BotConfig config;

    public TelegramBot(BotConfig config){
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()&& update.getMessage().hasText()){
            String message = update.getMessage().getText();
                    var originalMessage = update.getMessage();
                    log.debug(originalMessage.getText());

                    var respons = new SendMessage();
                    respons.setChatId(originalMessage.getChatId().toString());
                    respons.setText("Hello from bot");
                    sendAnswerMessage(respons);

            }

    }


    public void sendAnswerMessage(SendMessage message) {
        if (message != null) {
            try {
                execute(message);
            } catch (TelegramApiException e) {
                System.out.println(e);
            }
        }
    }



}

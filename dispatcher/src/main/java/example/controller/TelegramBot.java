package example.controller;


import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Log4j
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;
    private final UpdateController updateController ;
    @PostConstruct
    public void init() {
        updateController.registerBot(this);
    }

    @Autowired
    public TelegramBot(BotConfig config, UpdateController updateController) {
        this.config = config;
        this.updateController = updateController;
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
    updateController.processUpdate(update);
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

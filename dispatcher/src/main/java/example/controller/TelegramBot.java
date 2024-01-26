package example.controller;


<<<<<<< HEAD
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
=======
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
>>>>>>> 32c844dd547e5d2090bc06344e54f7570069b9bd
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
<<<<<<< HEAD
=======
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

>>>>>>> 32c844dd547e5d2090bc06344e54f7570069b9bd

@Component
@Log4j
public class TelegramBot extends TelegramLongPollingBot {

<<<<<<< HEAD
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
=======

    final BotConfig config;

    public TelegramBot(BotConfig config){
        this.config = config;
    }

>>>>>>> 32c844dd547e5d2090bc06344e54f7570069b9bd
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
<<<<<<< HEAD
    updateController.processUpdate(update);
=======
        if(update.hasMessage()&& update.getMessage().hasText()){
            String message = update.getMessage().getText();
                    var originalMessage = update.getMessage();
                    log.debug(originalMessage.getText());

                    var respons = new SendMessage();
                    respons.setChatId(originalMessage.getChatId().toString());
                    respons.setText("Hello from bot");
                    sendAnswerMessage(respons);

            }

>>>>>>> 32c844dd547e5d2090bc06344e54f7570069b9bd
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

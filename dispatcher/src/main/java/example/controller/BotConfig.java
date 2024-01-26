package example.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")
public class BotConfig {
<<<<<<< HEAD
    @Value("${bot.name}")
=======
    @Value("{$FirstWork_mybot_telegram_bot}")
>>>>>>> 32c844dd547e5d2090bc06344e54f7570069b9bd
    String botName;

    @Value("${bot.token}")
     String botToken;
}

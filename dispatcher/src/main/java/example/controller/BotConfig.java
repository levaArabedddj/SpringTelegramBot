package example.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")
public class BotConfig {
    @Value("{$FirstWork_mybot_telegram_bot}")
    String botName;

    @Value("${bot.token}")
     String botToken;
}

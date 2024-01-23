package example.controller;

import example.service.UpdateProducer;
import example.service.implement.UpdateProducerImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UpdateProducer updateProducer() {
        return new UpdateProducerImp();
    }

    // Другие бины и конфигурации...
}

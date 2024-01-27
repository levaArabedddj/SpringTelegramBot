package example.service.implement;

import example.service.UpdateProducer;
import lombok.extern.log4j.Log4j;
import org.jvnet.hk2.annotations.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;
@Service
@Log4j
public class UpdateProducerImp implements UpdateProducer {
    private final RabbitTemplate rabbitTemplate;

    public UpdateProducerImp(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void produce(String rabbitQueue, Update update) {
        log.debug(update.getMessage().getText());
        rabbitTemplate.convertAndSend(rabbitQueue,update);
    }
}

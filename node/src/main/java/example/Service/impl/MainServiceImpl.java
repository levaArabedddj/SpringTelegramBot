package example.Service.impl;

import example.Service.MainService;
import example.Service.ProducerService;
import example.dao.RAWDataDAO;
import example.entity.RawData;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MainServiceImpl implements MainService {
    private final RAWDataDAO rawDataDAO;
    private final ProducerService producerService;


    public MainServiceImpl(RAWDataDAO rawDataDAO, ProducerService producerService) {
        this.rawDataDAO = rawDataDAO;
        this.producerService = producerService;
    }

    @Override
    public void processTectMessage(Update update) {
        saveRawData(update);
        var message = update.getMessage();
        var sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Hello from NODE");
        producerService.producerAnswer(sendMessage);
    }

    private void saveRawData(Update update) {
        RawData rawData = RawData.builder().
                event(update)
                .build();
        rawDataDAO.save(rawData);
    }

}

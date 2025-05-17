// service/QueueConsumer.java
package com.example.notificationservice.service;

import com.example.notificationservice.config.RabbitMQConfig;
import com.example.notificationservice.model.Notification;
import com.example.notificationservice.repository.NotificationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class QueueConsumer {
    private final NotificationRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public QueueConsumer(NotificationRepository repo) {
        this.repository = repo;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(String msg) {
        try {
            Notification notification = mapper.readValue(msg, Notification.class);

            // Simulate sending
            System.out.println("Sending " + notification.getType() + " to User " + notification.getUserId());
            notification.setStatus("sent");

        } catch (Exception e) {
            e.printStackTrace();
            // Retry logic here
        }
    }
}

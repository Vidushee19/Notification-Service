// service/NotificationService.java
package com.example.notificationservice.service;

import com.example.notificationservice.config.RabbitMQConfig;
import com.example.notificationservice.model.Notification;
import com.example.notificationservice.repository.NotificationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final RabbitTemplate rabbitTemplate;
    private final NotificationRepository repository;

    public NotificationService(RabbitTemplate template, NotificationRepository repo) {
        this.rabbitTemplate = template;
        this.repository = repo;
    }

    public Notification send(Notification notification) {
        repository.save(notification);
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE, notification);
        return notification;
    }
}

// controller/NotificationController.java
package com.example.notificationservice.controller;

import com.example.notificationservice.model.Notification;
import com.example.notificationservice.repository.NotificationRepository;
import com.example.notificationservice.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationRepository repository;

    public NotificationController(NotificationService service, NotificationRepository repo) {
        this.notificationService = service;
        this.repository = repo;
    }

    @PostMapping("/notifications")
    public Notification sendNotification(@RequestBody Notification notification) {
        return notificationService.send(notification);
    }

    @GetMapping("/users/{id}/notifications")
    public List<Notification> getUserNotifications(@PathVariable String id) {
        return repository.findByUserId(id);
    }
}

package com.example.notificationservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
public class Notification {
    @Id
    private String id = UUID.randomUUID().toString();

    private String userId;
    private String type; // email, sms, in-app
    private String message;
    private String status = "queued";
    private int retryCount = 0;
    private LocalDateTime createdAt = LocalDateTime.now();
}

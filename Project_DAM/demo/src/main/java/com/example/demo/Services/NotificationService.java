package com.example.demo.Services;

import com.example.demo.Entity.Notification;
import com.example.demo.Repository.INotification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final INotification notificationRepository;

    public NotificationService(INotification notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Create a new Notification
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Get all Notifications
    public List<Notification> getAllNotifications() {
        return (List<Notification>) notificationRepository.findAll();
    }

    // Get Notification by ID
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    // Update Notification
    public Notification updateNotification(Long id, Notification updatedNotification) {
        return notificationRepository.findById(id).map(notification -> {
            notification.setUser(updatedNotification.getUser());
            notification.setValidityDate(updatedNotification.getValidityDate());
            notification.setInstrument(updatedNotification.getInstrument());
            return notificationRepository.save(notification);
        }).orElseThrow(() -> new RuntimeException("Notification not found with id: " + id));
    }

    // Delete Notification
    public void deleteNotification(Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Notification not found with id: " + id);
        }
    }
}

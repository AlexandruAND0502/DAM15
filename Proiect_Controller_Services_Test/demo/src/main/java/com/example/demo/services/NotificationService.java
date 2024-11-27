package com.example.demo.services;
import com.example.demo.magazin.Notification;
import com.example.demo.repository.INotification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final INotification notificationRepository;

    public NotificationService(INotification notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Iterable<Notification> findAll() {
        return notificationRepository.findAll();
    }

    public Notification findById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }
}
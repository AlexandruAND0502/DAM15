package com.example.demo.Repository;

import com.example.demo.Entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotification extends CrudRepository<Notification, Long> {

}

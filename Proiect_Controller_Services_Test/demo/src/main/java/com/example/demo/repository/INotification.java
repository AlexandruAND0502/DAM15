package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.magazin.Notification;

@Repository
public interface INotification extends CrudRepository<Notification, Long> {

}

package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.magazin.Reservation;

@Repository
public interface IReservation extends CrudRepository<Reservation, Long> {

}

package com.example.demo.Repository;

import com.example.demo.Entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservation extends CrudRepository<Reservation, Long> {

}

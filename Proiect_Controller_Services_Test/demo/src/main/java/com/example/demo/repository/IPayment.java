package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.magazin.Payment;

@Repository
public interface IPayment extends CrudRepository<Payment, Long> {

}

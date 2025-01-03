package com.example.demo.Repository;

import com.example.demo.Entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayment extends CrudRepository<Payment, Long> {

}

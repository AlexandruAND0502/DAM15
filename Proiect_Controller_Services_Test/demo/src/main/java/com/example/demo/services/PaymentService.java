package com.example.demo.services;

import com.example.demo.magazin.Payment;
import com.example.demo.repository.IPayment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final IPayment paymentRepository;

    public PaymentService(IPayment paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Iterable<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(Long id) {
        return (Payment) paymentRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }
}
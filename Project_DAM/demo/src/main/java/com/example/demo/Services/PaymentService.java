package com.example.demo.Services;

import com.example.demo.Entity.Payment;
import com.example.demo.Repository.IPayment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final IPayment paymentRepository;

    public PaymentService(IPayment paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Create a new Payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get all Payments
    public List<Payment> getAllPayments() {
        return (List<Payment>) paymentRepository.findAll();
    }

    // Get Payment by ID
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    // Update Payment
    public Payment updatePayment(Long id, Payment updatedPayment) {
        return paymentRepository.findById(id).map(payment -> {
            payment.setUser(updatedPayment.getUser());
            payment.setAdmin(updatedPayment.getAdmin());
            payment.setPaymentType(updatedPayment.getPaymentType());
            payment.setInstrument(updatedPayment.getInstrument());
            return paymentRepository.save(payment);
        }).orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    // Delete Payment
    public void deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Payment not found with id: " + id);
        }
    }
}

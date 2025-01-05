package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Payment;
import com.example.demo.Repository.IPayment;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private IPayment paymentRepository;

    // Obține toate plățile
    @GetMapping
    public Iterable<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Obține o plată după ID
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Creează o nouă plată
    @PostMapping
    public Payment createPayment(@RequestBody Payment newPayment) {
        return paymentRepository.save(newPayment);
    }

    // Actualizează o plată existentă
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        Optional<Payment> existingPayment = paymentRepository.findById(id);

        if (existingPayment.isPresent()) {
            Payment payment = existingPayment.get();
            payment.setPaymentType(updatedPayment.getPaymentType());
            payment.setUser(updatedPayment.getUser());
            payment.setAdmin(updatedPayment.getAdmin());
            payment.setInstrument(updatedPayment.getInstrument());
            paymentRepository.save(payment);
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Șterge o plată după ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

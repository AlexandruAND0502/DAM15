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

import com.example.demo.Entity.Rental;
import com.example.demo.Repository.IRental;

@RestController
@RequestMapping("/rentals") 
public class RentalController {

    @Autowired
    private IRental rentalRepository;

    // Obține toate închirierile
    @GetMapping
    public Iterable<Rental> getAllRentals() {
        return rentalRepository.findAll(); // Returnează toate închirierile
    }

    // Obține o închiriere după ID
    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable Long id) {
        Optional<Rental> rental = rentalRepository.findById(id);
        return rental.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Dacă nu există, returnează 404
    }

    // Creează o nouă închiriere
    @PostMapping
    public Rental createRental(@RequestBody Rental newRental) {
        return rentalRepository.save(newRental); // Salvează închirierea în baza de date
    }

    // Actualizează o închiriere existentă
    @PutMapping("/{id}")
    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @RequestBody Rental updatedRental) {
        Optional<Rental> existingRental = rentalRepository.findById(id);

        if (existingRental.isPresent()) {
            Rental rental = existingRental.get();
            rental.setBorrowedInstrument(updatedRental.getBorrowedInstrument());
            rental.setUser(updatedRental.getUser());
            rental.setRentDate(updatedRental.getRentDate());
            rental.setReturnDate(updatedRental.getReturnDate());
            rental.setMaximumAvailabilityDate(updatedRental.getMaximumAvailabilityDate());
            rentalRepository.save(rental); // Salvează modificările
            return ResponseEntity.ok(rental); // Returnează 200 cu închirierea actualizată
        } else {
            return ResponseEntity.notFound().build(); // Returnează 404 dacă nu găsește închirierea
        }
    }

    // Șterge o închiriere după ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        if (rentalRepository.existsById(id)) {
            rentalRepository.deleteById(id); // Șterge închirierea
            return ResponseEntity.noContent().build(); // Returnează 204 pentru succes
        } else {
            return ResponseEntity.notFound().build(); // Returnează 404 dacă nu există închirierea
        }
    }
}

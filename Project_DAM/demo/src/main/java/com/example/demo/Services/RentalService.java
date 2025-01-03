package com.example.demo.Services;

import com.example.demo.Entity.Rental;
import com.example.demo.Repository.IRental;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentalService {

    private final IRental rentalRepository;

    public RentalService(IRental rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    // Salvare Rental
    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    // Găsire Rental după ID
    public Optional<Rental> findRentalById(Long id) {
        return rentalRepository.findById(id);
    }

    // Actualizare Rental
    public Rental updateRental(Long id, Rental updatedRental) {
        return rentalRepository.findById(id).map(rental -> {
            rental.setBorrowedInstrument(updatedRental.getBorrowedInstrument());
            rental.setUser(updatedRental.getUser());
            rental.setRentDate(updatedRental.getRentDate());
            rental.setReturnDate(updatedRental.getReturnDate());
            rental.setMaximumAvailabilityDate(updatedRental.getMaximumAvailabilityDate());
            return rentalRepository.save(rental);
        }).orElseThrow(() -> new RuntimeException("Rental not found with id: " + id));
    }

    // Ștergere Rental
    public void deleteRental(Long id) {
        if (rentalRepository.existsById(id)) {
            rentalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Rental not found with id: " + id);
        }
    }
}

package com.example.demo.services;
import com.example.demo.magazin.Rental;
import com.example.demo.repository.IRental;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private final IRental rentalRepository;

    public RentalService(IRental rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental save(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Iterable<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public Rental findById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        rentalRepository.deleteById(id);
    }
}

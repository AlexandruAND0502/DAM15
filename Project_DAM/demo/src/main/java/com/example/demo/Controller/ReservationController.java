package com.example.demo.Controller;

import com.example.demo.Entity.Reservation;
import com.example.demo.Repository.IReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private IReservation reservationRepository;

    // Obține toate rezervările
    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll(); // Returnează toate rezervările
    }

    // Obține o rezervare după ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Dacă nu există, returnează 404
    }

    // Creează o nouă rezervare
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation newReservation) {
        return reservationRepository.save(newReservation); // Salvează rezervarea în baza de date
    }

    // Actualizează o rezervare existentă
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
        Optional<Reservation> existingReservation = reservationRepository.findById(id);

        if (existingReservation.isPresent()) {
            Reservation reservation = existingReservation.get();
            reservation.setUser(updatedReservation.getUser());
            reservation.setReservationDate(updatedReservation.getReservationDate());
            reservation.setReturnDate(updatedReservation.getReturnDate());
            reservation.setMaximumAvailabilityDate(updatedReservation.getMaximumAvailabilityDate());
            reservationRepository.save(reservation); // Salvează modificările
            return ResponseEntity.ok(reservation); // Returnează 200 cu rezervarea actualizată
        } else {
            return ResponseEntity.notFound().build(); // Returnează 404 dacă nu găsește rezervarea
        }
    }

    // Șterge o rezervare după ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id); // Șterge rezervarea
            return ResponseEntity.noContent().build(); // Returnează 204 pentru succes
        } else {
            return ResponseEntity.notFound().build(); // Returnează 404 dacă nu există rezervarea
        }
    }
}

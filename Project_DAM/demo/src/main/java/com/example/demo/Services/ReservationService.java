package com.example.demo.Services;

import com.example.demo.Entity.Reservation;
import com.example.demo.Repository.IReservation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private final IReservation reservationRepository;

    public ReservationService(IReservation reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Salvare Reservation
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Găsire Reservation după ID
    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Actualizare Reservation
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setUser(updatedReservation.getUser());
            reservation.setReservationDate(updatedReservation.getReservationDate());
            reservation.setReturnDate(updatedReservation.getReturnDate());
            reservation.setMaximumAvailabilityDate(updatedReservation.getMaximumAvailabilityDate());
            return reservationRepository.save(reservation);
        }).orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
    }

    // Ștergere Reservation
    public void deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Reservation not found with id: " + id);
        }
    }
}

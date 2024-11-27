package com.example.demo.services;
import com.example.demo.magazin.Reservation;
import com.example.demo.repository.IReservation;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final IReservation reservationRepository;

    public ReservationService(IReservation reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}
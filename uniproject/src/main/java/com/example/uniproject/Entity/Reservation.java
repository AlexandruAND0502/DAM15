package com.example.uniproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @ManyToOne 
    private User user;

    private Date reservationDate;
    private Date returnDate;
    private Date maximumAvailabilityDate; 

    public Reservation() {
    }

    public Reservation(Long idReservation, User user, Date reservationDate, Date returnDate, Date maximumAvailabilityDate) {
        this.idReservation = idReservation;
        this.user = user;
        this.reservationDate = reservationDate;
        this.returnDate = returnDate;
        this.maximumAvailabilityDate = maximumAvailabilityDate;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getMaximumAvailabilityDate() {
        return maximumAvailabilityDate;
    }

    public void setMaximumAvailabilityDate(Date maximumAvailabilityDate) {
        this.maximumAvailabilityDate = maximumAvailabilityDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", user=" + user.getUsername() + 
                ", reservationDate=" + reservationDate +
                ", returnDate=" + returnDate +
                ", maximumAvailabilityDate=" + maximumAvailabilityDate +
                '}';
    }
}

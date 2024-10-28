package com.example.uniproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentId;

    @ManyToOne 
    private Instrument borrowedInstrument;

    @ManyToOne 
    private User user;

    private Date rentDate; 
    private Date returnDate; 
    private Date maximumAvailabilityDate; 

    public Rental() {
    }

    public Rental(Long rentId, Instrument borrowedInstrument, User user, Date rentDate, Date returnDate, Date maximumAvailabilityDate) {
        this.rentId = rentId;
        this.borrowedInstrument = borrowedInstrument;
        this.user = user;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.maximumAvailabilityDate = maximumAvailabilityDate;
    }

    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }

    public Instrument getBorrowedInstrument() {
        return borrowedInstrument;
    }

    public void setBorrowedInstrument(Instrument borrowedInstrument) {
        this.borrowedInstrument = borrowedInstrument;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
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
        return "Rental{" +
                "rentId=" + rentId +
                ", borrowedInstrument=" + borrowedInstrument.getInstrumentName() + 
                ", user=" + user.getUsername() + 
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", maximumAvailabilityDate=" + maximumAvailabilityDate +
                '}';
    }
}

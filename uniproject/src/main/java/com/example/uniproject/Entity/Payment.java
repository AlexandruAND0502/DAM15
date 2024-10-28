package com.example.uniproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne //efectuata de utilizator
    private User user;

    @ManyToOne //dar adminul e baza...cred :))
    private Admin admin;

    private String paymentType; 

    @ManyToOne 
    private Instrument instrument;

    public Payment() {
    }

    public Payment(Long paymentId, User user, Admin admin, String paymentType, Instrument instrument) {
        this.paymentId = paymentId;
        this.user = user;
        this.admin = admin;
        this.paymentType = paymentType;
        this.instrument = instrument;
    }

    // Getters și Setters
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", user=" + user.getUsername() + 
                ", admin=" + admin.getName() + 
                ", paymentType='" + paymentType + '\'' +
                ", instrument=" + instrument.getInstrumentName() + 
                '}';
    }
}

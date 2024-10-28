package com.example.uniproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @ManyToOne
    private User user;

    private Date validityDate;

    @ManyToOne 
    private Instrument instrument;

    public Notification() {
    }

    public Notification(Long notificationId, User user, Date validityDate, Instrument instrument) {
        this.notificationId = notificationId;
        this.user = user;
        this.validityDate = validityDate;
        this.instrument = instrument;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", user=" + user.getUsername() + 
                ", validityDate=" + validityDate +
                ", instrument=" + instrument.getInstrumentName() + 
                '}';
    }
}

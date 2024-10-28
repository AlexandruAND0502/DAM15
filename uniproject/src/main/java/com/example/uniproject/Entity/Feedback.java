package com.example.uniproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @ManyToOne
    private User user;

    @ManyToOne 
    private Instrument instrument;

    private int star; 
    private String comment; 

    public Feedback() {
    }

    public Feedback(Long feedbackId, User user, Instrument instrument, int star, String comment) {
        this.feedbackId = feedbackId;
        this.user = user;
        this.instrument = instrument;
        this.star = star;
        this.comment = comment;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", user=" + user.getUsername() + 
                ", instrument=" + (instrument != null ? instrument.getInstrumentName() : "N/A") + 
                ", star=" + star +
                ", comment='" + comment + '\'' +
                '}';
    }
}

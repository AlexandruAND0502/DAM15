package com.example.uniproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instrumentId;

    private String instrumentName;
    private Date purchaseDate;
    private String instrumentState; 

    public Instrument() {
    }

    public Instrument(Long instrumentId, String instrumentName, Date purchaseDate, String instrumentState) {
        this.instrumentId = instrumentId;
        this.instrumentName = instrumentName;
        this.purchaseDate = purchaseDate;
        this.instrumentState = instrumentState;
    }

    public Long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getInstrumentState() {
        return instrumentState;
    }

    public void setInstrumentState(String instrumentState) {
        this.instrumentState = instrumentState;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instrumentId=" + instrumentId +
                ", instrumentName='" + instrumentName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", instrumentState='" + instrumentState + '\'' +
                '}';
    }
}

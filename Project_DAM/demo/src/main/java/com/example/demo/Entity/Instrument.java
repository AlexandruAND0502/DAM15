package com.example.demo.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instrumentId;

    private String instrumentName;
    private Date purchaseDate;
    private String instrumentState; 
    private String image_path;

    public Instrument() {
    }

    public Instrument(Long instrumentId, String instrumentName, Date purchaseDate, String instrumentState, String image_path) {
        this.instrumentId = instrumentId;
        this.instrumentName = instrumentName;
        this.purchaseDate = purchaseDate;
        this.instrumentState = instrumentState;
        this.image_path=image_path;
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
    public String getImagePath() {
        return image_path;
    }
    public void setImagePath(String image_path) {
        this.image_path = image_path;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instrumentId=" + instrumentId +
                ", instrumentName='" + instrumentName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", instrumentState='" + instrumentState + '\'' +
                ", image_path='"+image_path+'\''+
                '}';
    }
}
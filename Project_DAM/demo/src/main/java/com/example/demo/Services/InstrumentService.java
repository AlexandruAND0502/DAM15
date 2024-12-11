package com.example.demo.Services;

import com.example.demo.Entity.Instrument;
import com.example.demo.Repository.IInstrument;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstrumentService {

    private IInstrument instrumentRepository;

    // Obține toate instrumentele
    public Iterable<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    // Obține un instrument după ID
    public Optional<Instrument> getInstrumentById(Long id) {
        return instrumentRepository.findById(id);
    }

    // Creearea un nou instrument
    public Instrument createInstrument(Instrument newInstrument) {
        return instrumentRepository.save(newInstrument);
    }

    // Actualizarea un instrument existent
    public Instrument updateInstrument(Long id, Instrument updatedInstrument) {
        if (instrumentRepository.existsById(id)) {
            updatedInstrument.setInstrumentId(id); //setInstrumentId() pentru a seta ID-ul
            return instrumentRepository.save(updatedInstrument);
        } else {
            return null;  // Instrumentul nu există
        }
    }

    // Ștergerea unui instrument după ID
    public boolean deleteInstrument(Long id) {
        if (instrumentRepository.existsById(id)) {
            instrumentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

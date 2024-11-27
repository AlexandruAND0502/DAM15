package com.example.demo.services;
import com.example.demo.magazin.Instrument;
import com.example.demo.repository.IInstrument;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService {

    private final IInstrument instrumentRepository;

    public InstrumentService(IInstrument instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public Instrument save(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    @SuppressWarnings("unchecked")
    public Iterable<Instrument> findAll() {
        return (Iterable<Instrument>) (Instrument) instrumentRepository.findAll();
    }

    public Instrument findById(Long id) {
        return (Instrument) instrumentRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        instrumentRepository.deleteById(id);
    }
}
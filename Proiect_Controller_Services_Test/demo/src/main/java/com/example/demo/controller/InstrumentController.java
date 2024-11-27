package com.example.demo.controller;

import com.example.demo.magazin.Instrument;
import com.example.demo.services.InstrumentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @PostMapping
    public Instrument createInstrument(@RequestBody Instrument instrument) {
        return instrumentService.save(instrument);
    }

    @GetMapping("/{id}")
    public Instrument getInstrumentById(@PathVariable Long id) {
        return instrumentService.findById(id);
    }

    @GetMapping
    public Iterable<Instrument> getAllInstruments() {
        return instrumentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteInstrument(@PathVariable Long id) {
        instrumentService.deleteById(id);
    }
}
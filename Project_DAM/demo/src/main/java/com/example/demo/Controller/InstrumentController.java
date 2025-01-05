    package com.example.demo.Controller;

    import java.util.Optional;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.example.demo.Entity.Instrument;
    import com.example.demo.Repository.IInstrument;

    @RestController
    @RequestMapping("/instruments") //http://localhost:8006/instruments/{id}
    public class InstrumentController {

        @Autowired
        private IInstrument instrumentRepository;

        // Obține toate instrumentele
        @GetMapping
        public Iterable<Instrument> getAllInstruments() {
            return instrumentRepository.findAll();
        }

        // Obține un instrument după ID
        @GetMapping("/{id}")
        public ResponseEntity<Instrument> getInstrumentById(@PathVariable Long id) {
            Optional<Instrument> instrument = instrumentRepository.findById(id);
            return instrument.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Creează un nou instrument
        @PostMapping
        public Instrument createInstrument(@RequestBody Instrument newInstrument) {
            return instrumentRepository.save(newInstrument);
        }

        // Actualizează un instrument existent
        @PutMapping("/{id}")
        public ResponseEntity<Instrument> updateInstrument(@PathVariable Long id, @RequestBody Instrument updatedInstrument) {
            Optional<Instrument> existingInstrument = instrumentRepository.findById(id);

            if (existingInstrument.isPresent()) {
                Instrument instrument = existingInstrument.get();
                instrument.setInstrumentName(updatedInstrument.getInstrumentName());
                instrument.setPurchaseDate(updatedInstrument.getPurchaseDate());
                instrument.setInstrumentState(updatedInstrument.getInstrumentState());

                instrumentRepository.save(instrument);
                return ResponseEntity.ok(instrument);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // Șterge un instrument după ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteInstrument(@PathVariable Long id) {
            if (instrumentRepository.existsById(id)) {
                instrumentRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

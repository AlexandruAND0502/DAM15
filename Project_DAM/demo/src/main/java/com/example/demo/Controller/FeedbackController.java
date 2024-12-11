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

import com.example.demo.Entity.Feedback;
import com.example.demo.Repository.IFeedback;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private IFeedback feedbackRepository;

    // Obține toate feedback-urile
    @GetMapping
    public Iterable<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    // Obține un feedback după ID
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        return feedback.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Creează un nou feedback
    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback newFeedback) {
        return feedbackRepository.save(newFeedback);
    }

    // Actualizează un feedback existent
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback updatedFeedback) {
        Optional<Feedback> existingFeedback = feedbackRepository.findById(id);

        if (existingFeedback.isPresent()) {
            Feedback feedback = existingFeedback.get();
            feedback.setStar(updatedFeedback.getStar());
            feedback.setComment(updatedFeedback.getComment());
            feedback.setUser(updatedFeedback.getUser());
            feedback.setInstrument(updatedFeedback.getInstrument());
            feedbackRepository.save(feedback);
            return ResponseEntity.ok(feedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Șterge un feedback după ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

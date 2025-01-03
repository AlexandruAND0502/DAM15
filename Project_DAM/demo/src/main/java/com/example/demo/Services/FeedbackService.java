package com.example.demo.Services;

import com.example.demo.Entity.Feedback;
import com.example.demo.Repository.IFeedback;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final IFeedback feedbackRepository;

    public FeedbackService(IFeedback feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    // Create a new Feedback
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Get all Feedback entries
    public List<Feedback> getAllFeedback() {
        return (List<Feedback>) feedbackRepository.findAll();
    }

    // Get Feedback by ID
    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    // Update Feedback
    public Feedback updateFeedback(Long id, Feedback updatedFeedback) {
        return feedbackRepository.findById(id).map(feedback -> {
            feedback.setUser(updatedFeedback.getUser());
            feedback.setInstrument(updatedFeedback.getInstrument());
            feedback.setStar(updatedFeedback.getStar());
            feedback.setComment(updatedFeedback.getComment());
            return feedbackRepository.save(feedback);
        }).orElseThrow(() -> new RuntimeException("Feedback not found with id: " + id));
    }

    // Delete Feedback
    public void deleteFeedback(Long id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
        } else {
            throw new RuntimeException("Feedback not found with id: " + id);
        }
    }
}

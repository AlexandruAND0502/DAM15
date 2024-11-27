package com.example.demo.services;
import com.example.demo.magazin.Feedback;
import com.example.demo.repository.IFeedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final IFeedback feedbackRepository;

    public FeedbackService(IFeedback feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Iterable<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public Feedback findById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }
}
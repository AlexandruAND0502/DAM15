package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.magazin.Feedback;

@Repository
public interface IFeedback extends CrudRepository<Feedback, Long> {

 Feedback findFeedbackById(Long feedbackId);
}

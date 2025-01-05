package com.example.demo.Repository;

import com.example.demo.Entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeedback extends CrudRepository<Feedback, Long> {

}

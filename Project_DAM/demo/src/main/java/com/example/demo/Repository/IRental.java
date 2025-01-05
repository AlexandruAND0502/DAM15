package com.example.demo.Repository;

import com.example.demo.Entity.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRental extends CrudRepository<Rental, Long> {
}

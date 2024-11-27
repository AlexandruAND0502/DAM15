package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.magazin.Rental;

@Repository
public interface IRental extends CrudRepository<Rental, Long> {

}

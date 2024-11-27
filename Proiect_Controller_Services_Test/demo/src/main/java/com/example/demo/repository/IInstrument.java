package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.magazin.Instrument;

@Repository
public interface IInstrument extends CrudRepository<Instrument, Long> {

}

package com.example.demo.Repository;

import com.example.demo.Entity.Instrument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstrument extends CrudRepository<Instrument, Long> {

}

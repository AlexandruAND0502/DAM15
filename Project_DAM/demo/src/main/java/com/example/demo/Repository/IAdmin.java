package com.example.demo.Repository;

import com.example.demo.Entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdmin extends CrudRepository<Admin, Long> {

}

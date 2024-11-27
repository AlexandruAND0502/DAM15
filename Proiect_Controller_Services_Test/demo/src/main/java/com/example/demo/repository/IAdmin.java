package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.magazin.Admin;

@Repository
public interface IAdmin extends CrudRepository<Admin, Long> {
}

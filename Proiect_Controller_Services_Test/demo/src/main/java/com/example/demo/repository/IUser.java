package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.magazin.User;

@Repository
public interface IUser extends CrudRepository<User, Long> {

}

package com.example.gardengenie.repository;


import com.example.gardengenie.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{

}
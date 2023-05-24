package com.example.gardengenie.repository;


import com.example.gardengenie.domain.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long>{

}
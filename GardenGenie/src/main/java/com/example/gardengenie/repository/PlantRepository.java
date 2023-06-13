package com.example.gardengenie.repository;


import com.example.gardengenie.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    @Query(value = "SELECT p.plt_name FROM plant p ORDER BY p.created_at DESC LIMIT 1", nativeQuery = true)
    String findMostRecentPltName();

//    String findPlantNameByPltName(String pltName);
}
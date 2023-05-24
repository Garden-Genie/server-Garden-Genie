package com.example.gardengenie.GardenGenie;


import com.example.gardengenie.GardenGenie.Story;
import org.springframework.data.repository.CrudRepository;

public interface StoryRepository extends CrudRepository<Story, Long> {
}
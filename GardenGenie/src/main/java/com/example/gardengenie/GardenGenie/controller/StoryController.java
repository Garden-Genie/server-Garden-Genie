package com.example.gardengenie.GardenGenie.controller;


import com.example.gardengenie.GardenGenie.Plant;
import com.example.gardengenie.GardenGenie.Story;
import com.example.gardengenie.GardenGenie.StoryRepository;
import com.example.gardengenie.GardenGenie.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/Story")
public class StoryController {
    private StoryRepository storyRep;

    @Autowired
    public StoryController(StoryRepository storyRep){this.storyRep = storyRep;}

    @PostMapping
    public Story put(@RequestParam int storyId, @RequestParam User user, @RequestParam Plant plant, @RequestParam String pltName, @RequestParam LocalDateTime storyDate,
                     @RequestParam String storyExplain, @RequestParam String storyMusic, @RequestParam String storyPoem, @RequestParam String storyCondition){
        return storyRep.save(new Story(storyId, user, plant, pltName, storyDate, storyExplain, storyMusic, storyPoem, storyCondition));
    }

    @GetMapping
    public Iterable<Story> list(){return storyRep.findAll();}
}

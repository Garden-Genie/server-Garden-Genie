package com.example.gardengenie.controller;

import com.example.gardengenie.domain.Plant;
import com.example.gardengenie.repository.PlantRepository;
import com.example.gardengenie.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Plant")
public class PlantController {
    private PlantRepository plantRep;
    @Autowired
    public PlantController(PlantRepository plantRep){
        this.plantRep = plantRep;
    }

    //Post로 plant 추가
//    @PostMapping
//    public Plant put(@RequestParam int plt_id, @RequestParam int user_num, @RequestParam String plt_name, @RequestParam String plt_img){
//        return plantRep.save(new Plant(plt_id, user_num, plt_name, plt_img));
//    }

    //테이블 리스트 가져오기
    @GetMapping
    public Iterable<Plant> list(){
        return plantRep.findAll();
    }


}


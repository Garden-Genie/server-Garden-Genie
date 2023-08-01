package com.example.gardengenie.controller;

import com.example.gardengenie.domain.Plant;
import com.example.gardengenie.model.PlantRequestData;
import com.example.gardengenie.repository.PlantRepository;
import com.example.gardengenie.domain.User;
import com.example.gardengenie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/Plant")
public class PlantController {
    private PlantRepository plantRep;
    private UserRepository userRep;

    @Autowired
    public PlantController(PlantRepository plantRep, UserRepository userRep) {
        this.plantRep = plantRep;
        this.userRep = userRep;
    }


    //Post로 plant 추가(이전 기본 코드)
//    @PostMapping
//    public Plant put(@RequestParam int plt_id, @RequestParam int user_num, @RequestParam String plt_name, @RequestParam String plt_img){
//        return plantRep.save(new Plant(plt_id, user_num, plt_name, plt_img));
//    }

    @PostMapping
    public Plant put(@RequestBody PlantRequestData requestData) {
        // plt_id를 더 이상 requestData에서 가져오지 않음 (자동 생성됨)
        String user_id = requestData.getUser_id();

        // 요청에서 받은 user_id로 해당하는 User 엔티티를 데이터베이스에서 조회
        User user = userRep.findByUserId(user_id);

        if (user == null) {
            // 요청된 user_id에 해당하는 User가 데이터베이스에 존재하지 않는 경우 예외 처리
            throw new IllegalArgumentException("User with user_id " + user_id + " not found.");
        }

        // 조회한 User 엔티티를 Plant에 설정하여 저장
        return plantRep.save(new Plant(user, requestData.getPlt_name(), requestData.getPlt_img()));
    }


    //테이블 리스트 가져오기
    @GetMapping
    public Iterable<Plant> list(){
        return plantRep.findAll();
    }


}


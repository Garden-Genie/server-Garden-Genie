package com.example.gardengenie.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Plant")
public class Plant {

    @Id
    @GeneratedValue
    @Column(nullable = false, name = "plt_id")
    private int plt_id;

    @Column(length = 20, nullable = false, name = "plt_name")
    private String plt_name;

    @Column(nullable = false, name = "plt_img")
    private String plt_img;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    // Story 기능 미구현 : Story table 이용 X
//    @OneToOne(mappedBy = "plant")
//    private Story story;

    @Column(nullable = false)
    private LocalDateTime created_at; // createdAt 필드 추가

    public Plant(){
    }

    public Plant(int plt_id, User user, String plt_name, String plt_img){
        this.plt_id = plt_id;
        this.user = user;
        this.plt_img = plt_img;
        this.plt_name = plt_name;
        this.created_at = LocalDateTime.now(); // 생성 시간을 현재 시간으로 설정
    }
}

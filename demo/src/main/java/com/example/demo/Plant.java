package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private byte[] plt_img;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "plant")
    private Story story;

    public Plant(){
    }

    public Plant(int plt_id, User user, String plt_name, byte[] plt_img){
        this.plt_id = plt_id;
        this.user = user;
        this.plt_img = plt_img;
        this.plt_name = plt_name;

    }
}

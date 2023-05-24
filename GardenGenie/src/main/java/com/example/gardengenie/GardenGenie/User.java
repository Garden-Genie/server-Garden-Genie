package com.example.gardengenie.GardenGenie;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "User")
public class User {
    @Id
    @Column(length = 20, nullable = false)
    private String user_id;

    @Column(length = 20, nullable = false)
    private String user_name;

    @Column(length = 20, nullable = false)
    private String user_pwd;

    @Column(length = 50, nullable = false, unique = true)
    private String user_email;

    public User(){
    }

    public User(String user_name, String user_id, String user_email, String user_pwd){
        this.user_email = user_email;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }
}

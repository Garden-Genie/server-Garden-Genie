package com.example.gardengenie.domain;

import lombok.*;
import net.bytebuddy.matcher.FilterableList;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num", nullable = false)
    private Long userNum;

    @Column(name = "user_id", length = 20, nullable = false)
    private String userId;

    @Column(name = "user_name", length = 20, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String user_pwd;

    @Column(length = 50, nullable = false, unique = true)
    private String user_email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private List<Authority> roles = new ArrayList<>();

    public void setRoles(List<Authority> role){
        this.roles = role;
        role.forEach(o -> o.setUser(this));
    }

    public User(String user_name, String user_id, String user_email, String user_pwd){
        this.user_email = user_email;
        this.userId = user_id;
        this.userName = user_name;
        this.user_pwd = user_pwd;
    }
}

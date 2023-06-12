package com.example.gardengenie.model;

import com.example.gardengenie.domain.Authority;
import com.example.gardengenie.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SignResponse {

    private String id;

    private String name;

    private String email;

    private List<Authority> roles = new ArrayList<>();

    private String token;

    public SignResponse(User user) {
        this.id = user.getUserId();
        this.name = user.getUserName();
        this.email = user.getUser_email();
        this.roles = user.getRoles();
    }
}

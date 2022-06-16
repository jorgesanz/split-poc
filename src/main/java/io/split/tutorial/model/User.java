package io.split.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class User {

    private String name;
    private String role;

    @Setter
    private List<String> features;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }
}

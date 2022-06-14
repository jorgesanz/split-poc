package io.split.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class User {

    private String name;
    private List<String> features;

}

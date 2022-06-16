package io.split.tutorial.controller;

import io.split.tutorial.model.User;
import io.split.tutorial.model.Feature;
import io.split.tutorial.service.FeatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class FeaturesController {

    @Autowired
    private FeatureService featureService;

    private List<User> users = List.of(
            new User("Francisco", "test"),
            new User("Jorge", "test"),
            new User("Juan", "test"),
            new User("Maria", "user"),
            new User("Marta", "user"),
            new User("Noelia", "user"),
            new User("Alberto", "user"),
            new User("Lucas", "user"),
            new User("Sandra", "user"),
            new User("Mario", "user"));
    private Map<String, String> hardcodedFeatures = Map.of("feature-1", "1", "feature-2", "2");

    @Autowired
    private List<Feature> features;


    @GetMapping(path = "/features")
    public ResponseEntity<List<User>> features() {
        try {
            return ResponseEntity.ok(evaluate());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().body(new ArrayList<>());
        }
    }


    public List<User> evaluate() {

        return users.stream().map(user -> obtainFeatures(user)).collect(Collectors.toList());
    }

    public User obtainFeatures(User user) {

        List<String> featureNames = featureService.filterByUser(user.getName()).stream().map(Feature::getName).toList();
        user.setFeatures(featureNames);

        return user;
    }


}

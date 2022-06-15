package io.split.tutorial.controller;

import io.split.client.SplitClient;
import io.split.tutorial.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class FeaturesController {

    @Autowired
    private SplitClient splitClient;


    @Value("${split.example}")
    private String example;

    private List<String> users = List.of("test1", "test2", "test3", "user1", "user2", "user3", "user4", "user5", "user6", "user7");
    private Map<String, String> features = Map.of("feature-flag", "X", "feature-2", "2");


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

        return users.stream().map(user -> getStrings(user)).collect(Collectors.toList());
    }

    public User getStrings(String user) {

        try {
            List<String> activeFeatures = features.entrySet().stream()
                    .map(feature -> evaluateTreatment(user, feature.getKey(), feature.getValue()))
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());

            return new User(user, activeFeatures);

        } catch (Exception e) {
            log.error(e.getMessage());
            return new User(user, new ArrayList<>());
        }
    }

    private Optional<String> evaluateTreatment(String user, String featureName, String featureValue) {

        String treatment = obtainTreatment(user, featureName);
        if (treatment.equals("on")) {
            return Optional.of(featureValue);
        } else {
            return Optional.empty();
        }
    }

    private String obtainTreatment(String user, String featureName) {
        return splitClient.getTreatment(user, featureName);
    }

}

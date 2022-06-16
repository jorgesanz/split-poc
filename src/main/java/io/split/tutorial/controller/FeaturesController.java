package io.split.tutorial.controller;

import com.ferrovial.architecture.split.model.User;
import io.split.tutorial.service.FeatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class FeaturesController {

    @Autowired
    private FeatureService featureService;

    @GetMapping(path = "/features")
    public ResponseEntity<List<User>> features() {
        try {
            return ResponseEntity.ok(featureService.evaluateAllUsersFeatures());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().body(new ArrayList<>());
        }
    }




}

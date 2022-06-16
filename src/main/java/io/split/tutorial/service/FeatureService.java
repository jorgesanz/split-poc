package io.split.tutorial.service;

import com.ferrovial.architecture.split.model.User;
import com.ferrovial.architecture.split.service.SplitService;
import io.split.tutorial.model.Feature;
import io.split.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureService extends SplitService<Feature> {

    @Autowired
    private UserRepository userRepository;

    public FeatureService(List<Feature> splitElements) {
        super(splitElements);
    }

    public List<User> evaluateAllUsersFeatures() {

        return userRepository.findAll().stream().map(user -> obtainFeatures(user)).collect(Collectors.toList());
    }

    public User obtainFeatures(User user) {

        List<String> featureNames = this.filterByUser(user).stream().map(Feature::getName).toList();
        user.setFeatures(featureNames);

        return user;
    }
}

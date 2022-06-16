package io.split.tutorial.service;

import com.ferrovial.architecture.split.service.SplitService;
import io.split.tutorial.model.Feature;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService extends SplitService<Feature> {

    public FeatureService(List<Feature> splitElements) {
        super(splitElements);
    }
}

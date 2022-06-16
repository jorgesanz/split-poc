package io.split.tutorial.model;

import com.ferrovial.architecture.split.annotation.SplitFeature;

@SplitFeature(name = "feature-1")
public class Feature1 implements Feature{
    @Override
    public String getName() {
        return "1";
    }
}

package io.split.tutorial.model;

import com.ferrovial.architecture.split.annotation.SplitFeature;

@SplitFeature(name = "feature-3")
public class Feature3 implements Feature{
    @Override
    public String getName() {
        return "3";
    }
}

package io.split.tutorial.model;

import com.ferrovial.architecture.split.annotation.SplitFeature;

@SplitFeature(name = "feature-2")
public class Feature2 implements Feature{
    @Override
    public String getName() {
        return "2";
    }
}

package com.learnJava.streams.behaviourParameterisation;

import com.learnJava.streams.Apple;

public class AppleGreenPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}

package com.learnJava.streams.behaviourParameterisation;

import com.learnJava.streams.Apple;

public class AppleHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>=150;
    }
}

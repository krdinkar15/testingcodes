package com.learnJava.streams;

public class Apple
{
    String color;
    int weight;
    String size;

    public Apple(String color, int weight, String size) {
        this.color = color;
        this.weight = weight;
        this.size = size;
    }

    public Apple() {

    }

    public Apple(Integer weight) {
        this.weight=weight;
    }

    public Apple(String color, Integer weight) {
        this.color=color;
        this.weight=weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", size='" + size + '\'' +
                '}';
    }
}

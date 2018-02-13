package com.test.entity;
/**
 * 1、每个方法返回对象自身
 * 2、每个方法返回一个新的对象(和原方法所属对象同类型的对象)
 * Person p=new Person("sbbic",20);
 * p.setWeight(50).setHeight(172).setAge(24);
 * 此类用第1种方法实现方法键
 */
public class Person {
    private String name;//必须属性
    private int age;//必须属性

    private float weight;//体重,非必须
    private float height;//身高,非必须

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Person(String name, int age, float weight, float height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public Person setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public Person setHeight(float height) {
        this.height = height;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }
}

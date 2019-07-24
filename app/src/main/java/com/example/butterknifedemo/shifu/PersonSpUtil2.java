package com.example.butterknifedemo.shifu;

@SP(name = "mypr2")
public interface PersonSpUtil2 {

    @SPData(key = "name")
    void saveName(String value);

    @SPData(key = "age")
    int getAge();
}
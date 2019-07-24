package com.example.butterknifedemo.shifu;

@SP(name = "aa")
public interface PersonSpUtil {

    @SPData(key = "name")
    void saveName(String value);

    @SPData(key = "name")
    String getName();
}

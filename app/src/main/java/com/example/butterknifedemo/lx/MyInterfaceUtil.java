package com.example.butterknifedemo.lx;
@Sp(value = "myvalue")
public interface MyInterfaceUtil {
    @SPData(value = "mydata")
    public void save(String s);

    @SPData(value = "mydata")
    public String get(String string);

}

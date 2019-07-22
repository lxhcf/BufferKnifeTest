package com.example.butterknifedemo;

class InjectUtils {
    public static void inject(MainActivity mainActivity) {

        ViewIDInjector.process(mainActivity);
        ClickProcessor.process(mainActivity);
    }
}

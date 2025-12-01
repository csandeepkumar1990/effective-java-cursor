package com.effectivejava.item20.preferinterfaces;

/**
 * Example of a class implementing multiple interfaces.
 * This demonstrates the power of interfaces - you can't do this with abstract classes.
 */
public class SingerSongwriter implements Singer, Songwriter {
    @Override
    public void sing() {
        System.out.println("Singing a song");
    }
    
    @Override
    public void compose() {
        System.out.println("Composing a song");
    }
}


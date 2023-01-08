package com.rockpaperscissors.game.service;

import java.util.Random;

public class RandomChoiceService {
    Random rand = new Random();

    public int getRandom(){
        return rand.nextInt(3)+1;
    }

}

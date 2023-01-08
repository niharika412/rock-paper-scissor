package com.rockpaperscissors.game.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class RandomChoiceServiceTest {

    @InjectMocks
    RandomChoiceService randomChoiceService;

    @Test
    public void randomChoiceServiceNumberGreaterThanOneTest(){
        assert(randomChoiceService.getRandom()>=1);
    }

    @Test
    public void randomChoiceServiceNumberLessThanThreeTest(){
        assert(randomChoiceService.getRandom()<=3);
    }
}

package com.rockpaperscissors.game.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class ScoreTest {

    @InjectMocks
    Score score;

    @Test
    public void getTotalGamesTest(){
        score.setTotalNumberOfGamesPlayed(3);
        assertEquals(3,score.getTotalNumberOfGamesPlayed());
    }

    @Test
    public void getUserWinsTest(){
        score.setTimesUserWon(3);
        assertEquals(3,score.getTimesUserWon());
    }

    @Test
    public void decrementTotalTest(){
        score.setTotalNumberOfGamesPlayed(3);
        score.decrementGameTotal();
        assertEquals(2,score.getTotalNumberOfGamesPlayed());
    }

}

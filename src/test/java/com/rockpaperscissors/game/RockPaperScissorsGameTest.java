package com.rockpaperscissors.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@RunWith(SpringJUnit4ClassRunner.class)
public class RockPaperScissorsGameTest {

    @Mock
    RockPaperScissorsGame rockPaperScissorsGame;

    @Test
    public void rpsGameTest(){
        String input = "test\n1\n1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertDoesNotThrow(()->rockPaperScissorsGame.main(new String[]{""}));
    }
}

package com.rockpaperscissors.game.controller;

import com.rockpaperscissors.game.entity.Player;
import com.rockpaperscissors.game.entity.RPSAction;
import com.rockpaperscissors.game.exceptions.InvalidChoiceException;
import com.rockpaperscissors.game.service.RandomChoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class RPSControllerTest {

    @InjectMocks
    RPSController rpsController;

    @Mock
    RandomChoiceService randomChoiceService;


    @Test
    public void getComputerDetailsTest(){
        assertEquals("Computer",rpsController.getComputerDetails().getUserName());
    }

    @Test
    public void getComputerActionTest(){
        when(randomChoiceService.getRandom()).thenReturn(2);
        assertEquals(RPSAction.PAPER,rpsController.getComputerAction());
    }

    @Test
    public void calculateResultsUserWinsTest(){
        rpsController.setUserAction(RPSAction.PAPER);
        rpsController.setComputerAction(RPSAction.ROCK);
        assertEquals(rpsController.calculateResults(), Player.USER);
    }

    @Test
    public void calculateResultsComputerWinsTest(){
        rpsController.setUserAction(RPSAction.ROCK);
        rpsController.setComputerAction(RPSAction.PAPER);
        assertEquals(rpsController.calculateResults(), Player.COMPUTER);
    }

    @Test
    public void calculateResultsTieTest(){
        rpsController.setUserAction(RPSAction.ROCK);
        rpsController.setComputerAction(RPSAction.ROCK);
        assertEquals(rpsController.calculateResults(), Player.TIE);
    }

    @Test
    public void gamesRemainingTest(){
        assertEquals(0,rpsController.gamesRemaining());
    }

    @Test
    public void setUserActionTest(){
        assertEquals(RPSAction.SCISSORS,rpsController.setUserAction(3));
    }

    @Test
    public void setUserActionExceptionTest(){
        assertThrows(InvalidChoiceException.class,()->rpsController.setUserAction(-1));
    }

    @Test
    public void setUserDetailsTest(){
        assertEquals("user",rpsController.setUserDetails("user",3).getUserName());
    }

}

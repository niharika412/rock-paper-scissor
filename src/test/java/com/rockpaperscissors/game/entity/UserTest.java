package com.rockpaperscissors.game.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @InjectMocks
    User user;

    @Test
    public void getUserNameTest(){
        user.setUserName("user");
        assertEquals("user",user.getUserName());
    }

    @Test
    public void getUserScoreTest(){
        user.setUserScore(2);
        assertEquals(2,user.getUserScore());
    }
}

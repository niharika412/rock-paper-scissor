package com.rockpaperscissors.game.controller;


import com.rockpaperscissors.game.entity.Player;
import com.rockpaperscissors.game.entity.RPSAction;
import com.rockpaperscissors.game.entity.Score;
import com.rockpaperscissors.game.entity.User;
import com.rockpaperscissors.game.exceptions.InvalidChoiceException;
import com.rockpaperscissors.game.service.RandomChoiceService;

import java.util.Scanner;

public class RPSController {

    private RPSAction userAction;
    private RPSAction computerAction;

    private Score totalScore = new Score();

    RandomChoiceService randomChoiceService = new RandomChoiceService();
    User user = new User();
    User computer = new User();
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public User getUserDetails(){
        System.out.println("Welcome to Rock Paper Scissors Game! \n " +
                "What is your name? \n");
        user.setUserName(scanner.nextLine());
        System.out.println("How many matches would you like to play today?");
        totalScore.setTotalNumberOfGamesPlayed(scanner.nextInt());
        return user;
    }

    public User getComputerDetails(){
        computer.setUserName("Computer");
        return computer;
    }

    public RPSAction getUserAction() {
        System.out.println("Below are the options to choose from :\n" +
                "1.Rock\n" +
                "2.Paper\n" +
                "3.Scissors");
        RPSAction userActionTemp = RPSAction.getValue(scanner.nextInt());
        if(userAction==RPSAction.INVALID){
            throw new InvalidChoiceException("Invalid Choice. Choose one out of (1.Rock,2.Paper,3.Scissors)");
        }
        setUserAction(userActionTemp);
        return userActionTemp;
    }

    public int gamesRemaining(){
        return totalScore.getTotalNumberOfGamesPlayed();
    }


    public void setUserAction(RPSAction action){
        this.userAction=action;
    }

    public void setComputerAction(RPSAction action){
        this.computerAction=action;
    }


    public RPSAction getComputerAction(){
        RPSAction action= RPSAction.getValue(randomChoiceService.getRandom());
        this.computerAction=action;
        return action;
    }

    public Player calculateResults(){
        totalScore.decrementGameTotal();
        if(userAction == computerAction){
            return Player.TIE;
        }else if(userAction.beats == computerAction.label){
            user.incrementUserScore();
            return Player.USER;
        }else{
            computer.incrementUserScore();
            return Player.COMPUTER;
        }
    }

}

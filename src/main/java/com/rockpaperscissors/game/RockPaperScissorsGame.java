package com.rockpaperscissors.game;


import com.rockpaperscissors.game.controller.RPSController;
import com.rockpaperscissors.game.entity.Player;
import com.rockpaperscissors.game.entity.RPSAction;
import com.rockpaperscissors.game.entity.User;

import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RPSController rpsController = new RPSController();

        rpsController.getUserDetails();
        String userName = scanner.nextLine();
        rpsController.getMatchDetails();
        int totalGames = scanner.nextInt();

        User userDetails = rpsController.setUserDetails(userName,totalGames);

        User compDetails = rpsController.getComputerDetails();

        while(rpsController.gamesRemaining()>0){
            rpsController.getUserAction();
            RPSAction user =rpsController.setUserAction(scanner.nextInt());

            RPSAction computer =rpsController.getComputerAction();

            Player winner = rpsController.calculateResults();


            System.out.printf("%s played %s and Computer player %s \n\n",
                    userDetails.getUserName(),user.label,computer.label);
            if(winner.equals(Player.USER)){
                System.out.println("You won!\n");
            }else if(winner.equals(Player.COMPUTER)){
                System.out.println("Computer won!\n");
            }else{
                System.out.println("Its a TIE!\n");
            }
        }

        System.out.printf("Total matches played = %s\n" + "%s won= %s times \n" + "%s won= %s times \n"+
                        "It was a tie %s times.",
                totalGames,userDetails.getUserName(),
                userDetails.getUserScore(),compDetails.getUserName(),compDetails.getUserScore(),
                totalGames- userDetails.getUserScore()- compDetails.getUserScore());

    }
}

package com.rockpaperscissors.game.entity;

public class User {

    private String userName;
    private int userScore;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void incrementUserScore(){
        this.userScore+=1;
    }



}

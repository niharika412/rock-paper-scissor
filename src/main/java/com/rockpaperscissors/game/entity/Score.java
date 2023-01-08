package com.rockpaperscissors.game.entity;

public class Score {

    private int totalNumberOfGamesPlayed;

    private int timesUserWon;

    public void decrementGameTotal(){
        totalNumberOfGamesPlayed-=1;
    }

    public int getTotalNumberOfGamesPlayed() {
        return totalNumberOfGamesPlayed;
    }

    public void setTotalNumberOfGamesPlayed(int totalNumberOfGamesPlayed) {
        this.totalNumberOfGamesPlayed = totalNumberOfGamesPlayed;
    }

    public int getTimesUserWon() {
        return timesUserWon;
    }

    public void setTimesUserWon(int timesUserWon) {
        this.timesUserWon = timesUserWon;
    }

    public void incrementUserWon(){
        timesUserWon+=1;
    }
}

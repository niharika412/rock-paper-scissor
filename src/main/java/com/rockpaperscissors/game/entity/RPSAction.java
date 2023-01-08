package com.rockpaperscissors.game.entity;

public enum RPSAction {

    ROCK(1,3),
    PAPER(2,1),
    SCISSORS(3,2),
    INVALID(-1,-1);

    public final int label;

    public final int beats;

    private RPSAction(int label, int beats) {
        this.label = label;
        this.beats = beats;
    }

    public static RPSAction getValue(int userChoice){
        for(RPSAction rpsAction: RPSAction.values()){
            if(rpsAction.label==userChoice){
                return rpsAction;
            }
        }
        return INVALID;
    }
}

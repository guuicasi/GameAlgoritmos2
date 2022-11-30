package com.mycompany.game;

import java.io.IOException;

public abstract class Player {
    
    protected int[] attempt = new int[2];
    protected int id;
    protected String name;

    
    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public abstract void play(Board board) throws IOException;
    
    public abstract void Attempt(Board board);

    public boolean checkAttempt(int[] attempt, Board board){
        if(board.getPosition(attempt) == 0) {
            return true;
        }
        else {
            return false;
        }
            
    }
    
}
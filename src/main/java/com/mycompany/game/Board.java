package com.mycompany.game;

import java.io.IOException;

public class Board {
    private int[][] board= new int[3][3];
    
    public Board(){
        resetBoard();
    }
    
    public void resetBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                board[line][column]=0;
    }
    
    public void showBoard() throws IOException{
        System.out.println();

        for(int line=0 ; line<3 ; line++){
            String newLine = "";
        
            for(int column=0 ; column<3 ; column++){
                if(board[line][column]==-1){
                    System.out.print(" X ");
                    newLine = newLine.concat(" X ");
                }
                if(board[line][column]==1) {
                    System.out.print(" O ");
                    newLine = newLine.concat(" O ");
                }
                if(board[line][column]==0){
                    System.out.print("   ");
                    newLine = newLine.concat("   ");
                }
                
                if(column==0 || column==1) {
                    System.out.print("|");
                    newLine = newLine.concat("|");
                }
            }

            Historic.InsertLine(newLine);
            System.out.println();
        }
                
    }

    public int getPosition(int[] choose){
        return board[choose[0]][choose[1]];
    }
    
    public void setPosition(int[] choose, int id) throws IOException{
        if(id == 1) {
            board[choose[0]][choose[1]] = -1;
        } else {
            board[choose[0]][choose[1]] = 1;
        }
        
        showBoard();
    }

    public int checkLines(){
        for(int line=0 ; line<3 ; line++){

            if( (board[line][0] + board[line][1] + board[line][2]) == -3)
                return -1;
            if( (board[line][0] + board[line][1] + board[line][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkColumns(){
        for(int column=0 ; column<3 ; column++){

            if( (board[0][column] + board[1][column] + board[2][column]) == -3)
                return -1;
            if( (board[0][column] + board[1][column] + board[2][column]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkDiagonals(){
        if( (board[0][0] + board[1][1] + board[2][2]) == -3)
            return -1;
        if( (board[0][0] + board[1][1] + board[2][2]) == 3)
            return 1;
        if( (board[0][2] + board[1][1] + board[2][0]) == -3)
            return -1;
        if( (board[0][2] + board[1][1] + board[2][0]) == 3)
            return 1;
        
        return 0;
    }

    public boolean fullBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                if( board[line][column]==0 )
                    return false;
        return true;
    }
}
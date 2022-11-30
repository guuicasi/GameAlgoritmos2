package com.mycompany.game;

import java.io.IOException;
import java.util.Scanner;

public class Human extends Player {
    public Scanner input = new Scanner(System.in);
    
    public Human(int id, String name){
        super(id, name);
        this.id = id;
        this.name = name;
        System.out.println("Jogador " + name + " criado!");
    }
    
    @Override
    public void play(Board board) throws IOException{
        Attempt(board);
        board.setPosition(attempt, id);
    }
    
    @Override
    public void Attempt(Board board){
        do{
            do{
                System.out.print("Linha: ");
                attempt[0] = input.nextInt();
                
                if( attempt[0] > 3 ||attempt[0] < 1)
                    System.out.println("Linha inválida. É 1, 2 ou 3");
                
            }while( attempt[0] > 3 ||attempt[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                attempt[1] = input.nextInt();
                
                if(attempt[1] > 3 ||attempt[1] < 1)
                    System.out.println("Coluna inválida. É 1, 2 ou 3");
                
            }while(attempt[1] > 3 ||attempt[1] < 1);
            
            attempt[0]--; 
            attempt[1]--;
            
            if(!checkAttempt(attempt, board))
                System.out.println("Esse local já foi marcado. Tente outro.");
        }while( !checkAttempt(attempt, board) );
    }
}
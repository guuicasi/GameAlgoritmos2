package com.mycompany.game;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Game {
    private Board board;
    private int round=1, turn=1;
    private Player player1;
    private Player player2;
    public Scanner input = new Scanner(System.in);

    
    public Game() throws IOException{
        board = new Board();
        
        startPlayers();
        
        while( Play() );
    }
    
    public void startPlayers() throws IOException{
        String firstName = "";
        String secondeName = "";
        LocalDate localDate = LocalDate.now();

        Historic.InsertLine("-----------------------------------------");
        Historic.InsertLine(localDate.toString());
        Historic.InsertLine("-----------------------------------------");
        Historic.InsertLine("Quem vai ser o Jogador 1 ?");
        System.out.println("Quem vai ser o Jogador 1 ?");

        System.out.print("Nome: ");
        firstName = input.nextLine();

        this.player1 = new Human(1, firstName);

        Historic.InsertLine("Nome: " + firstName);

        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2 ?");

        Historic.InsertLine("-----------------------------------------");
        Historic.InsertLine(" Quem vai ser o Jogador 2 ?");

        System.out.print("Nome: ");
        secondeName = input.nextLine();

        this.player2 = new Human(2, secondeName);

        Historic.InsertLine("Nome: " + secondeName);
    }
    
    public boolean Play() throws IOException{
        if(Won() == 0 ) {
            System.out.println("----------------------");
            System.out.println("\nRodada "+ round);
            System.out.println("É a vez do jogador " + Turn().name );

            Historic.InsertLine("-----------------------------------------");
            Historic.InsertLine("\nRodada "+ round);
            Historic.InsertLine("É a vez do jogador " + Turn().name );
            
            if(Turn().id ==1) {
                player1.play(board);
            } else {
                player2.play(board);
            }
            
            
            if(board.fullBoard()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                Historic.InsertLine("\nTabuleiro Completo. Jogo empatado\n");
                return CheckPlayAgain();
            } 

            turn++;
            round++;

            return true;
        } else {
            if(Won() == -1 ) {
                System.out.println("Jogador " + player1.name + " ganhou!");
                Historic.InsertLine("\nJogador " + player1.name + " ganhou!\n");
            } else {
                System.out.println("Jogador " + player2.name + " ganhou!");
                Historic.InsertLine("\nJogador " + player2.name + " ganhou!\n");
                
            }

            return CheckPlayAgain();
        }
            
    }

    public boolean CheckPlayAgain() {
        boolean validade = false;
        int option = 0;

        do {
            System.out.println("Deseja jogar novamente: \n" + "1 - SIM\n" + "2 - NÃO\n" + "Opção: ");
            option = input.nextInt();

            if (option == 1) {
                validade = true;
                turn = 1;
                round = 1;
            } else if (option != 2) {
                System.out.println("Opção inválida!");
            }
        } while (option != 2 && option != 1);

        board.resetBoard();

        return validade;
    }
    
    public Player Turn(){
        if(turn%2 == 1)
            return player1;
        else
            return player2;
    }
    
    public int Won(){
        if(board.checkLines() == 1)
            return 1;
        if(board.checkColumns() == 1)
            return 1;
        if(board.checkDiagonals() == 1)
            return 1;
        
        if(board.checkLines() == -1)
            return -1;
        if(board.checkColumns() == -1)
            return -1;
        if(board.checkDiagonals() == -1)
            return -1;
        
        return 0;
    }
    
    
}
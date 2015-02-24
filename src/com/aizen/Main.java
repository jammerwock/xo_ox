package com.aizen;

import java.util.Scanner;

public class Main {

    static final int PLAYER_X = 0;
    static final int PLAYER_O = 1;
    static final int CODE_SIGN_X = 1;
    static final int CODE_SIGN_O = -1;
    static final char SIGN_X = 'X';
    static final char SIGN_O = 'O';
    static final char SIGN_FREE = ' ';
    static int[] field;
    static int size;
    static int side;
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Enter field side size: ");
        side = sc.nextInt();
        size = side * side;
        field = new int[size];

       run();
    }

    static void run(){
        printField();
        int winner = 0;
        for (int i = 0; i < size && winner == 0 ; i++) {
            processInput(i % 2);
            printField();
            winner = checkWin(i % 2);
        }
        if(winner != 0){
            System.out.println("Player " + (winner == CODE_SIGN_X ?SIGN_X:SIGN_O) + " wins!");
        }else {
            System.out.println("Draw!");
        }
    }
    static int checkWin(int player){
        return 0;
    }
    static void processInput(int player){
        int pos;
        do{
            System.out.println("Player " + ( player == PLAYER_X ? SIGN_X : SIGN_O ) + ": ");
            pos = sc.nextInt();
        }while (pos > size || pos < 0 || field[pos - 1] != 0);
        field[pos - 1] = player == PLAYER_X ? CODE_SIGN_X : CODE_SIGN_O;
    }
    static void printField(){
        int line;
        String row;
        for (int i = 0; i < size;) {
            line = side;
            row = "";
            while (line-- != 0){
                row += String.format("|%c", getSignByCode(field[i++]));
            }
            row += "|";
            System.out.println(row);
        }
    }
    public static char getSignByPlayer(int player){
        switch (player){
            case PLAYER_X: return SIGN_X;
            case PLAYER_O: return SIGN_O;
        }
    }
    public static char getSignByCode(int sign){
        switch (sign){
            case CODE_SIGN_X: return SIGN_X;
            case CODE_SIGN_O: return SIGN_O;
            default:          return SIGN_FREE;
        }
    }
}



package tic.tac.toe;

import java.util.Random;
public class Board {
    private final int[][] board = new int[3][3];
    
    public void instructionBoard(){
        System.out.println("| - | - | - |");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| - | - | - |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| - | - | - |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| - | - | - |");
    }
    
    public void displayBoard(){
        System.out.println("| - | - | - |");
        System.out.println(printRow(0));
        System.out.println("| - | - | - |");
        System.out.println(printRow(1));
        System.out.println("| - | - | - |");
        System.out.println(printRow(2));
        System.out.println("| - | - | - |");
    }
    
    private String printRow(int row){
        StringBuilder rowToDisplay = new StringBuilder("| ");
        for(int i = 0 ; i < 3 ;i++){
            if(board[row][i] == 0) rowToDisplay.append(" ");
            if(board[row][i] == 1) rowToDisplay.append("X");
            if(board[row][i] == 2) rowToDisplay.append("0");
            rowToDisplay.append(" | ");
        }
        rowToDisplay.deleteCharAt(rowToDisplay.lastIndexOf(" "));
        return rowToDisplay.toString();
    }
    
    public boolean placepeice (int position , String peicetype){
        int row = (position-1)/3;
        int coloumn = (position-(row*3))-1;
        if(board[row][coloumn] == 0){
            if(peicetype.equals("X")) board[row][coloumn] = 1;
            if(peicetype.equals("O")) board[row][coloumn] = 2;
            return true;
        }
        return false;
    }
    
    public boolean placepeicerandomly(String peicetype){
        int row = new Random().nextInt(3);
        int coloumn = new Random().nextInt(3);
        boolean waspeiceplaced = false;
        
        while(!waspeiceplaced && !ismatrixfull()){
            if(board[row][coloumn] == 0){
               if(peicetype.equals("X")) board[row][coloumn] = 1;
               if(peicetype.equals("O")) board[row][coloumn] = 2;
               return true; 
            }
            else{
               row = new Random().nextInt(3);
               coloumn = new Random().nextInt(3);
            }
        }
        return waspeiceplaced;
        }
    public int[][] getBoard(){
        return board;
    }
    
    public boolean ismatrixfull(){
        for(int row = 0 ; row < 3 ; row++){
            for(int coloumn = 0 ; coloumn < 3 ; coloumn++){
                if(board[row][coloumn] == 0) return false;
        }
        }
        return true;
    }
    
    
    
}

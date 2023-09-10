/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;



public class GameResolver {
    public static boolean arethepeicesinline(int [][] board, int row, int coloumn){
        int gamepiece = board[row][coloumn];
        if(gamepiece == 0){
            return false;
        }
        //down direction
        boolean iscelloutofboard = (row+1 > board.length-1 || row+2 > board.length-1);
        
        if(!iscelloutofboard && board[row+1][coloumn] == gamepiece && board[row+2][coloumn] == gamepiece){
            return true;
        }
        
        //up direction
        iscelloutofboard = (row-1 < 0);
        if(!iscelloutofboard && board[row-1][coloumn] == gamepiece){
           iscelloutofboard = (row-2 < 0);
           if(!iscelloutofboard && board[row-2][coloumn] == gamepiece){
               return true;   
        }
        }
        
        //right up direction
        iscelloutofboard = (row-1 < 0) || (coloumn+1 > board[0].length-1);
        if(!iscelloutofboard && board[row-1][coloumn+1] == gamepiece){
             iscelloutofboard = (row-2 < 0) || (coloumn+2 > board[0].length-1);
             if(!iscelloutofboard && board[row-2][coloumn+2] == gamepiece){
               return true;   
        }
        }
        
        //right direction
        iscelloutofboard = (coloumn+1 > board[0].length-1);
        if(!iscelloutofboard && board[row][coloumn+1] == gamepiece){
              iscelloutofboard = (coloumn+2 > board[0].length-1); 
              if(!iscelloutofboard && board[row][coloumn+2] == gamepiece){
                  return true;     
        }
        }
        
        //right down direction
        iscelloutofboard = (row+1 > board.length-1 || (coloumn+1 > board[0].length-1));
        if(!iscelloutofboard && board[row+1][coloumn+1] == gamepiece){
              iscelloutofboard = (row+2 > board.length-1) || (coloumn+2 > board[0].length-1); 
              if(!iscelloutofboard && board[row+2][coloumn+2] == gamepiece){
                  return true;     
        }
     }
       
        //left down direction
        iscelloutofboard = row+1> board.length-1 || (coloumn-1 < 0);
        if(!iscelloutofboard && board[row+1][coloumn] == gamepiece){
              iscelloutofboard = row+2>board.length-1||(coloumn-2 < 0); 
              if(!iscelloutofboard && board[row+2][coloumn-2] == gamepiece){
                  return true;     
        }
     }
        //left direction
        iscelloutofboard = (coloumn-1 < 0);
        if(!iscelloutofboard && board[row][coloumn-1] == gamepiece){
              iscelloutofboard = (coloumn-2 < 0); 
              if(!iscelloutofboard && board[row][coloumn-2] == gamepiece){
                  return true;     
        }
     }
        
        //left up direction
         iscelloutofboard = (row-1 <0 ) || (coloumn-1 < 0);
        if(!iscelloutofboard && board[row-1][coloumn-1] == gamepiece){
              iscelloutofboard = (row-2 < 0) || (coloumn-2 < 0); 
              if(!iscelloutofboard && board[row-2][coloumn-2] == gamepiece){
                  return true;     
        }
     }
        
        return false;
    }
    
    
    public static GameState resolve(int[][] board){
        for(int row = 0 ; row < 3 ; row++){
            for(int coloumn = 0 ; coloumn < 3 ; coloumn++){
                boolean threeconsecutivecells = arethepeicesinline(board,row,coloumn);
                if(threeconsecutivecells){
                    if(board[row][coloumn] == 1) return GameState.X_won;
                    else return GameState.O_won;
                }
        }
        } 
        return GameState.In_progress;
    } 
    
    
    public enum GameState{In_progress , X_won , O_won;}
}
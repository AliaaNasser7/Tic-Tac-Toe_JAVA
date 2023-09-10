

package tic.tac.toe;

import java.util.Scanner;
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner (System.in);
        Board board = new Board();
        board.instructionBoard();
        System.out.println("Enter Position");
        int position = scanner.nextInt();
        
        board.placepeice(position, "X");
        
        boolean isGameinprogress = true;
        while(isGameinprogress && !board.ismatrixfull()){
            board.placepeicerandomly("O");
            board.displayBoard();
            
            isGameinprogress = GameResolver.resolve(board.getBoard()) == GameResolver.GameState.In_progress;
            
            if(!isGameinprogress){
                System.out.println("GAME OVER!!!!");
                System.out.println("You Are The Winner");
                break;
            }
            else{
              System.out.println("Enter Another Position");
              position = scanner.nextInt();
              board.placepeice(position, "X");
              
            }
        }
    }
    
}

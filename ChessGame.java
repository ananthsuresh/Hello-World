/**
 * @author Ananth Suresh
 * This interface defines the basic moves of the Chess Game
 */

import javax.swing.JFrame;
import javax.swing.JButton;

public interface ChessGame{
  
 /**
  * This is a method stub that checks if the input ChessPiece is legal to play at the given turn
  * @param piece is the Chess Piece to check if is legal to play
  * @return returns either true or false depending on if the piece is legal to play
  */
  public boolean legalPieceToPlay(ChessPiece piece);
  
 /**
  * This is a method stub that performs a chess move
  * @param piece is the Chess Piece to move
  * @param row is the row the piece is on
  * @param column is the column the piece is on
  * @return returns either true or false depending on if the move was performed, or not if it was illegal
  */  
  public boolean makeMove(ChessPiece piece, int row, int column);
  
  //this is an enum type that defines the two sides of the opposing players//
  public enum Side {NORTH, SOUTH} ;
}
    
  
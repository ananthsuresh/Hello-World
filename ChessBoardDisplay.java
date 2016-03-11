/**
 * @author Ananth Suresh
 * This interface defines the visuals for the chess board
 */

import javax.swing.JFrame;
import javax.swing.JButton;

public interface ChessBoardDisplay{
  
 /**
  * This is a method stub that creates the visuals for the empty square on the chess board
  * @param emptySquare is the square on the chess board to display
  * @param row is the row that the button is on
  * @param column is the column the button is on
  */
  public void displayEmptySquare(JButton emptySquare, int row, int column);
  
 /**
  * This is a method stub that creates the visuals for the filled square on the chess board
  * @param filledSquare is the square on the chess board to display
  * @param row is the row that the button is on
  * @param column is the column the button is on
  * @param chessPiece is the piece located on that square
  */
  public void displayFilledSquare(JButton filledSquare, int row, int column, ChessPiece chessPiece);
 
  /**
  * This is a method stub that highlights a square on the board
  * @param highlight represents if you want the highlight on or off
  * @param square is the square on the chessboard to highlight or not highlight
  * @param row is the row that the button is on
  * @param column is the column the button is on
  * @param chessPiece is the piece located on that square, if any
  */
  public void highlightSquare(boolean highlight, JButton square, int row, int column, ChessPiece chessPiece);
  
}  
  
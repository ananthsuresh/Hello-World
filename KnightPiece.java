import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;

/**
 * @author Ananth Suresh
 * This class represents a Knight Piece
 */
public class KnightPiece extends ChessPiece{
 
 /**
  * This is a constructor for the knight piece
  * @param color assigns the color of the chess piece
  */
  public KnightPiece(Color color){
    this.setColor(color);
    if(color == Color.RED){
      this.setSide(Side.NORTH);
    }
    else{
      this.setSide(Side.SOUTH);
    }
    this.setLabel("N");
    this.setIcon(new ImageIcon("knightpiece.png"));
  }
  
 /**
  * This overrides the existing rowDiff method to provide negative values
  * @param row is the row the piece is to be moved to 
  * @return an integer representing the number and direction of rows moved
  */
  public int rowDiff(int row){
    return row - getRow();
  }
  
 /**
  * This overrides the existing columnDiff method to provide negative values
  * @param column is the column the piece is to be moved to 
  * @return an integer representing the number and direction of columns moved
  */
  public int columnDiff(int column){
    return column - getColumn();
  }
  
 /**
  * This method checks if movement is in a legal L shape
  * @param row is the row the piece is to be moved to 
  * @param column is the column the piece is to be moved to
  * @return a boolean representing if the move is legal
  */
  public boolean isL(int row, int column){
    //checks for all possible L combinations//
    if((column - getColumn() == 1) && (row - getRow() == 2)){
      return true;
    }
    else if(column - getColumn() == 1 && row - getRow() == -2){
      return true;
    }
      
    else if((column - getColumn() == -1) && ((row - getRow() == 2))){
      return true;
    }
    else if((column - getColumn() == -1) && ((row - getRow() == -2))){
      return true;
    }
      
    else if((column - getColumn() == 2) && ((row - getRow() == -1))){
      return true;
    }
    
    else if((column - getColumn() == 2) && ((row - getRow() == 1))){
      return true;
    }
    
    else if((column - getColumn() == -2) && ((row - getRow() == -1))){ 
      return true;
    }
    else if((column - getColumn() == -2) && ((row - getRow() == 1))){ 
      return true;
    }
    else{
      return false;
    }
  }
  
 /**
  * This checks if Knight has any pieces in its path
  * @param row is the row the piece is to be moved to 
  * @param column is the column the piece is to be moved to
  * @return a boolean representing if the path is clear
  */
  public boolean clearPath(int row, int column){
    
    //checks the path for all possible movements//
    if(columnDiff(column) == 2){
      if((getChessBoard().getPiece(getRow(), getColumn() + 1)) == null){
        return true;
      }
      else{
        return false;
      }  
    }
    
    else if(columnDiff(column) == -2){
      if((getChessBoard().getPiece(getRow(), getColumn() - 1)) == null){
        return true;
      }
      else{
        return false;
      }  
    }
    
    else if( rowDiff(row) == 2){
      if((getChessBoard().getPiece(getRow() + 1, getColumn()) == null)) {
        return true;
      }
      else{
        return false;
      }
    }
    else if(rowDiff(row) == -2){
      if((getChessBoard().getPiece(getRow() - 1, getColumn()) == null)) {
        return true;
      }
      else{
        return false;
      }
    }
    else{
      return false;
    }
  }
    

 /**
  * This is a checks if it is a legal non capture move for the piece
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */ 
  public boolean isLegalNonCaptureMove(int row, int column){
    //checks if L shape move//
    if(isL(row, column)){
      //checks if path is clear//
      if(clearPath(row,column)){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      return false;
    }
  }

  
  

        
      
  
  
}
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;

/**
 * @author Ananth Suresh
 * This class represents an Elephant Piece 
 */
public class ElephantPiece extends ChessPiece{
  
 /**
  * This is a constructor the elephant piece
  * @param color assigns the color of the chess piece
  */
  public ElephantPiece(Color color){
    this.setColor(color);
    //sets the Side of the piece based on the color//
    if(color == Color.RED){
      this.setSide(Side.NORTH);
    }
    else{
      this.setSide(Side.SOUTH);
    }
    this.setLabel("E");
    this.setIcon(new ImageIcon("elephantpiece.png"));
  }
  
 /**
  * This is a method that overrides the isHorizontal method in ChessPiece to move two squares
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it was a horizontal move of two squares
  */
  @Override
  public boolean isHorizontal(int row, int column){
    //checks if piece is moved horizontally by 2 squares//
    if((row - this.getRow()) == 2 || (row - this.getRow()) == -2){
      return true;
    }
    else{
      return false;
    }
  }
  
 /**
  * This is a method that overrides the isVertical method in ChessPiece to move two squares
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it was a hvertical move of two squares
  */
  public boolean isVertical(int row, int column){
    //checks if piece is moved vertically by 2 squares//
    if((column - this.getColumn()) == 2 || (column - this.getColumn()) == -2){
      return true;
    }
    else{
      return false;
    }
  }
  
 /**
  * This is a checks if there is no piece diagonal to it 
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is clear to move over
  */
  public boolean diagonalPiece(int row, int column){
    //variable that stores whether the north right diagonal is clear//
    boolean northRight = true;
    //variable that stores whether the north left diagonal is clear//
    boolean northLeft = true;
    //variable that stores whether the south right diagonal is clear//
    boolean southRight = true;
    //variable that stores whether the south left diagonal is clear//
    boolean southLeft = true;
    
    //checks the top right diagonal//
    if(this.getSide() == Side.NORTH){
      if(column > this.getColumn()){
        if((this.getChessBoard().getPiece(row - 1, column - 1) == null) && (this.getChessBoard().getPiece(row +1, column - 1) == null)){
          northRight = true;
        }
        else{
          northRight = false;
        }
      }
      //checks the top left diagonal//
      else{
        if((this.getChessBoard().getPiece(row +1, column +1) == null) && (this.getChessBoard().getPiece(row -1, column+1) == null)){
          northLeft = true;
        }
        else{
          northLeft = false;
        }
      }
      
      //checks if both diagonals on the upper side are clear..
      if(northRight == true && northLeft == true){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      //checks the bottom right diagonal//
      if(column > this.getColumn()){
        if((this.getChessBoard().getPiece(row +1, column - 1) == null) && (this.getChessBoard().getPiece(row - 1, column - 1) == null)){
          southRight = true;
        }
        else{
          southRight = false;
        }
      }
      //checks the bottom left diagonal//
      else{
        if((this.getChessBoard().getPiece(row + 1, column + 1) == null) && (this.getChessBoard().getPiece(row -1, column + 1) == null)){
          southLeft = true;
        }
        else{
          southLeft = false;
        }
      }
      
      //checks if both the diagonals on the lower side are clear//
      if(southRight == true && southLeft == true){
        return true;
      }
      else{
        return false;
      }
    }
  }
      

 /**
  * This is a checks if it is a legal non capture move for the piece
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */
  public boolean isLegalNonCaptureMove(int row, int column){
    //checks if diagonal is clear//
    if(diagonalPiece(row,column)){
      if(getSide() == Side.NORTH){
        //checks if piece is within bounds//
        if(row > 4){
          return false;
        }
        else{
          //checks if it is a legal move for the piece//
          if(isVertical(row,column) && isHorizontal(row,column)){
            return true;
          }
          else{
            return false;
          }
        }
      }
      else{
        //checks if piece is within bounds//
        if(row < 5){
          return false;
        }
        else{
          if(isVertical(row,column) && isHorizontal(row,column)){
            return true;
          }
          else{
            return false;
          }
        }
      }
    }
    else{
      return false;
    }
  }
  

      
          
  
  
}
  
    
    
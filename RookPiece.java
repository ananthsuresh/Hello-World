import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;

/**
 * @author Ananth Suresh
 * This class represents a Rook Piece
 */
public class RookPiece extends ChessPiece{
  
 /**
  * This is a constructor for the Rook piece
  * @param color assigns the color of the chess piece
  */
  public RookPiece(Color color){
    this.setColor(color);
    if(color == Color.RED){
      this.setSide(Side.NORTH);
    }
    else{
      this.setSide(Side.SOUTH);
    }
    this.setLabel("R");
    this.setIcon(new ImageIcon("rookpiece.png"));
  }
  
 /**
  * This is a checks if it is a legal non capture move for the piece
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */ 
  public boolean isLegalNonCaptureMove(int row, int column){
    //variable that stores the number of empty squares along the path//
    int freeSquare = 0;
    //if moving along more than one axis//
    if(columnDiff(column) > 0 && rowDiff(row) > 0){
      return false;
    }
    else{
      if(columnDiff(column) > 0){
        if(column > getColumn()){
          //loops through the path and detects if path is empty//
          for(int i = getColumn() + 1; i < column; i++){
            if(getChessBoard().getPiece(getRow(),i) == null){
              freeSquare++;
            }
          }
          if(freeSquare + 1 == columnDiff(column)){
            return true;
          }
          else{
            return false;
          }
        }
        else{
          for(int i = getColumn() - 1; i > column; i--){
            if(getChessBoard().getPiece(getRow(),i) == null){
              freeSquare++;
            }
          }
          if(freeSquare + 1 == columnDiff(column)){
            return true;
          }
          else{
            return false;
          }
        }
      }
      else{
        if(row > getRow()){
          for(int i = getRow() + 1; i < row; i++){
            if(getChessBoard().getPiece(i,getColumn()) == null){
              freeSquare++;
            }
          }
          if(freeSquare + 1 == rowDiff(row)){
            return true;
          }
          else{
            return false;
          }
        }
        else{
          for(int i = getRow() - 1; i > row; i--){
            if(getChessBoard().getPiece(i,getColumn()) == null){
              freeSquare++;
            }
          }
          if(freeSquare + 1 == rowDiff(row)){
            return true;
          }
          else{
            return false;
          }
        }
      }
    }
  }
  

}
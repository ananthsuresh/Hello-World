import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;

/**
 * @author Ananth Suresh
 * This class represents a Pawn Piece
 */
public class PawnPiece extends ChessPiece{
 
 /**
  * This is a constructor for the pawn piece
  * @param color assigns the color of the chess piece
  */
  public PawnPiece(Color color){
    this.setColor(color);
    if(color == Color.RED){
      this.setSide(Side.NORTH);
    }
    else{
      this.setSide(Side.SOUTH);
    }
    this.setLabel("P");
    this.setIcon(new ImageIcon("pawnpiece.png"));
  }
  
 /**
  * This is a checks if it is a legal non capture move for the piece
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */ 
  public boolean isLegalNonCaptureMove(int row, int column){
    if(getSide() == Side.NORTH){
      //checks if before halfway//
      if(getRow() < 5){
        if(rowDiff(row) > 1){
          return false;
        }
        else{
          if(columnDiff(column) > 0){
            return false;
          }
          else if (rowDiff(row) == 1 && columnDiff(column) == 1){
            return false;
          }
          else{
            return true;
          }
        }
      }
      //after halfway//
      else{
        if(rowDiff(row) > 1){
          return false;
        }
        else{
          if(columnDiff(column) > 1){
            return false;
          }
          else if (rowDiff(row) == 1 && columnDiff(column) == 1){
            return false;
          }
          else{
            return true;
          }
        }
      }
    }
    //if on the other side//
    else{
      if(getRow() > 4){
        if(rowDiff(row) > 1){
          return false;
        }
        else{
          if(columnDiff(column) > 0){
            return false;
          }
          else if (rowDiff(row) == 1 && columnDiff(column) == 1){
            return false;
          }
          else{
            return true;
          }
        }
      }
      else{
        if(rowDiff(row) > 1){
          return false;
        }
        else{
          if(columnDiff(column) > 1){
            return false;
          }
          else if (rowDiff(row) == 1 && columnDiff(column) == 1){
            return false;
          }
          else{
            return true;
          }
        }
      }
    }
  }
  
    

      
        
}
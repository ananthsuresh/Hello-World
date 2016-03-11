import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;

/**
 * @author Ananth Suresh
 * This class represents a King Piece
 */
public class KingPiece extends ChessPiece{
  
 /**
  * This is a constructor for the king piece
  * @param color assigns the color of the chess piece
  */
  public KingPiece(Color color){
    this.setColor(color);
    if(color == Color.RED){
      this.setSide(Side.NORTH);
    }
    else{
      this.setSide(Side.SOUTH);
    }
    this.setLabel("K");
    this.setIcon(new ImageIcon("kingpiece.png"));
  }
    
 /**
  * This is a checks if it is a legal non capture move for the piece
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */ 
  public boolean isLegalNonCaptureMove(int row, int column){
    if(getSide() == Side.NORTH){
      //checks if king is within palace//
      if(column < 3 || column > 5 || row >2){
        return false;
      }
      else{
        //checks if King moves more than one square//
        if(rowDiff(row) > 1 || columnDiff(column) > 1){
          return false;
        }
        //checks if king moves diagonal//
        else if(rowDiff(row) == 1 && columnDiff(column) == 1){
          return false;
        }
        else{
          return true;
        }
      }
    }

    else{
       if(column < 3 || column > 5 || row < 7){
        return false;
      }
      else{
        if(rowDiff(row) > 1 || columnDiff(column) > 1){
          return false;
        }
        else if(rowDiff(row) == 1 && columnDiff(column) == 1){
          return false;
        }
        else{
          return true;
        }
      }
    }
  }
      
 
  

      
  
}
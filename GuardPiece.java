import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;

/**
 * @author Ananth Suresh
 * This class represents a Guard Piece
 */
public class GuardPiece extends ChessPiece{
 
 /**
  * This is a constructor for the guard piece
  * @param color assigns the color of the chess piece

  */
  public GuardPiece(Color color){
    this.setColor(color);
    if(color == Color.RED){
      this.setSide(Side.NORTH);
    }
    else{
      this.setSide(Side.SOUTH);
    }
    this.setLabel("G");
    this.setIcon(new ImageIcon("guardpiece.png"));
  }
  
 /**
  * This is a checks if it is a legal non capture move for the piece
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */
  public boolean isLegalNonCaptureMove(int row, int column){
    if(getSide() == Side.NORTH){
      //makes sure guard is within palace//
      if(column < 3 || column > 5 || row >2){
        return false;
      }
      else{
        //checks if a diagonal move is made//
        if((isVertical(row,column)) && (isHorizontal(row,column))){
          return true;
        }
        else{
          return false;
        }
      }
    }
    else{
      if(column < 3 || column > 5 || row < 7){
        return false;
      }
      else{
        if((isVertical(row,column)) && (isHorizontal(row,column))){
          return true;
        }
        else{
          return false;
        }
      }
    }
  }
  


  
}
  
  
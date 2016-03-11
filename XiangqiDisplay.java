import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;

/**
 * @author Ananth Suresh
 * This class defines the graphics for the XiangQi game
 */
public class XiangqiDisplay implements ChessBoardDisplay{
  
 /**
  * This is a constructor that creates the XiangQiDisplay
  */
  public XiangqiDisplay(){
  }
  
 /**
  * This is a method that defines the visuals for an empty square
  * @param emptySquare is the button whose graphics will be modified
  * @param row is the row of the empty square
  * @param column is the column of the empty square
  */
  public void displayEmptySquare(JButton emptySquare, int row, int column){
    //sets the background color to gray//
    emptySquare.setBackground(java.awt.Color.gray);
    //removes any text//
    emptySquare.setText(null);
    emptySquare.setIcon(null);
  }
  
 /**
  * This is a method that defines the visuals for an filled square
  * @param filledSquare is the button whose graphics will be modified
  * @param row is the row of the filled square
  * @param column is the column of the filed square
  */
  public void displayFilledSquare(JButton filledSquare, int row, int column, ChessPiece chessPiece){
    //sets the background color to the color of the chessPiece//
    filledSquare.setBackground(chessPiece.getColor());
    //sets the text of the button to the label of the chessPiece on the square//
    filledSquare.setText(chessPiece.getLabel());
    //sets the icon of the square to the icon of the chesspiece on the square//
    filledSquare.setIcon(chessPiece.getIcon());
  }
  
  
 /**
  * This is a method that overrides ChessBoard display's highlight method
  * @param highlight represents whether the highlight is on or off
  * @param square is the button to be highlighted
  * @param row is the row of the JButton
  * @param column is the column of the JButton
  * @param chessPiece is the piece located on that square
  */
  @Override
  public void highlightSquare(boolean highlight, JButton square, int row, int column, ChessPiece chessPiece){
    //checks if highlight is on//
    if(highlight){
      square.setBackground(Color.yellow);
    }
    //if highlight is off//
    else{
      //and if there is a chess piece on the square//
      if(chessPiece != null){
        //uses graphics for a filled square//
        this.displayFilledSquare(square, row, column, chessPiece);
      }
      //if there is no piece on the square//
      else{
        //uses graphics for an empty square//
        this.displayEmptySquare(square, row, column);
      }
    }
  }
        
}
  
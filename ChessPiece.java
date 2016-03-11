import java.awt.*;
import java.lang.*;
import javax.swing.*;

/**
 * @author Ananth Suresh
 * an abstract class that is the superclass for all chess pieces and has common methods used in a lot of them
 */
public abstract class ChessPiece implements ChessGame{
  
 /**
  * @value variable that will store the chessBoard that the piece is on
  */
  private ChessBoard chessBoard;
 /**
  * @value stores the color linked to the piece
  */
  private java.awt.Color color;
 /**
  * @value stores the label of the piece that represents its identity
  */
  private String label;
 /**
  * @value stores the icon of the piece
  */
  private javax.swing.Icon icon;
 /**
  * @value stores the side that the piece is on
  */
  private Side side;
 /**
  * @value stores the row in the array that the piece is on
  */
  private int row;
 /**
  * @value stores the column in the array that the piece is on
  */
  private int column;
  
  
 /**
  * This is a method that sets the chess board of a chess piece
  * @param board is the ChessBoard that is assigned to the piece
  */
  public void setChessBoard(ChessBoard board){
    this.chessBoard = board;
  }
  
 /**
  * This is a method that gets the chess board of a chess piece
  * @return board that the piece is on
  */
  public ChessBoard getChessBoard(){
    return chessBoard;
  }
  
 /**
  * This is a method that gets the color of a chess piece
  * @return the color of the piece
  */
  public java.awt.Color getColor(){
    return color;
  }
  
 /**
  * This is a method that sets the color of a chess piece
  * @param color is the color that the piece is to be set to
  */
  public void setColor(Color color){
    this.color = color;
  }
  
 /**
  * This is a method that sets the label of a chess piece
  * @param label is a String input that is set as the piece's label
  */
  public void setLabel(String label){
    this.label = label;
  }

 /**
  * This is a method that gets the label of a chess piece
  * @return the label of the ChessPiece
  */
  public String getLabel(){
    return label;
  }
  
 /**
  * This is a method that gets the icon of a chess piece
  * @return the icon of the ChessPiece
  */
  public javax.swing.Icon getIcon(){
    return icon;
  }
  
 /**
  * This is a method that sets the icon of a chess piece
  * @param icon that is set as the piece's icon
  */
  public void setIcon(javax.swing.Icon icon){
    this.icon = icon;
  }
  
 /**
  * This is a method that sets the side of a chess piece
  * @param side that is assigned to the chess piece
  */
  public void setSide(Side side){
    this.side = side;
  }
  
 /**
  * This is a method that gets the Side of a chess piece
  * @return the Side of the ChessPiece
  */
  public Side getSide(){
    return side;
  }
  
 /**
  * This is a method that sets the row of a chess piece
  * @param row that the chess piece is put in
  */
  public void setRow(int row){
    this.row = row;
  }
  
 /**
  * This is a method that gets the row of a chess piece in the array
  * @return the row in the array that the piece is in
  */
  public int getRow(){
    return row;
  }
  
 /**
  * This is a method that sets the column of a chess piece
  * @param column that the chess piece is put in
  */
  public void setColumn(int column){
    this.column = column;
  }
  
 /**
  * This is a method that gets the column of a chess piece in the array
  * @return the column in the array that the piece is in
  */
  public int getColumn(){
    return column;
  }
  
  
  public boolean isLegalMove(int row, int column){
    //if there is a piece on destination square//
    if((this.getChessBoard().getPiece(row,column)) != null){
      //if the piece on the destination square is a piece of the same team//
      if((this.getChessBoard().getPiece(row,column)).getSide() == this.getSide()){
        return false;
      }
      else{
        return true;
      }
    }
    else{
      return true;
    }
  }
  

 /**
  * This is a method that does nothing but represents that the move was successfully completed
  */
  public void moveDone(){
  }
  
 /**
  * This is a method that checks if a horizontal move of one square has been made
  * @param row the row that piece is moved to
  * @param column is the column the piece is moved to
  */
  public boolean isHorizontal(int row, int column){
    //checks if there is a horizontal move on either side//
    if((column - this.getColumn()) == 1 || (column - this.getColumn()) == -1){
      return true;
    }
    else{
      return false;
    }
  }
  
 /**
  * This is a method that checks if a vertical move of one square has been made
  * @param row the row that piece is moved to
  * @param column is the column the piece is moved to
  */
  public boolean isVertical(int row, int column){
    //checks if there is a vertical move on either side//
    if((row - this.getRow()) == 1 || (row - this.getRow()) == -1){
      return true;
    }
    else{
      return false;
    }
  }
  
 /**
  * This is a method that returns how many rows the piece has been moved
  * @param row the row that piece is moved to
  * @return number of rows that the piece is moved
  */
  public int rowDiff(int row){
    //calculates difference and calls absolute value//
    return Math.abs(row - getRow());
  }
  
 /**
  * This is a method that returns how many columns the piece has been moved
  * @param column the column that piece is moved to
  * @return number of column that the piece is moved
  */
  public int columnDiff(int column){
    return Math.abs(column - getColumn());
  }
    
 /**
  * This is a method that simply returns true and exists because ChessPiece implements ChessGame
  * @param row the row that piece is moved to
  * @param column is the column the piece is moved to
  * @param piece is the piece that is moved
  * @return boolean indicating if move was made
  */      
  public boolean makeMove(ChessPiece piece, int row, int column){
    return true;
  }
  
 /**
  * This is a method that simply returns true and exists because ChessPiece implements ChessGame
  * @param piece is the piece that is moved
  * @return boolean is it is legal to play
  */      
  public boolean legalPieceToPlay(ChessPiece piece){
    return true;
  }
  
 /**
  * This is a method that checks if the move is a legal capture move
  * @param row is the row the piece is moved to
  * @param column is the column the piece is moved to
  * @return boolean is it is legal capture move
  */      
  public boolean isLegalCaptureMove(int row, int column){
    //checks is piece to be captured is on the same team//
    if(this.getSide() == (this.getChessBoard().getPiece(row,column)).getSide()){
      return false;
    }
    else{
      return isLegalNonCaptureMove(row,column);
    }
  }
  
 /**
  * This is a method that simply returns true and exists because ChessPiece implements ChessGame
  * @param row is the row the piece is moved to
  * @param column is the column the piece is moved to
  * @return boolean is it is legal non capture move
  */      
  public boolean isLegalNonCaptureMove(int row, int column){
    return true;
  }
  
}
      

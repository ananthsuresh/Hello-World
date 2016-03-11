
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;
import java.lang.*;

/**
 * @author Ananth Suresh
 * This class represents the XiangQi variant of the Chess Game and has methods with respect to this specific form of Chess
 */
public class Xiangqi implements ChessGame{
  
 /**
  * @value chessBoard is a variable that stores the Xiangqi chessBoard
  */
  private ChessBoard chessBoard;
 /**
  * @value xiangqiDisplay stores the graphics for the Xiangqi game
  */
  private XiangqiDisplay xiangqiDisplay;
 /**
  * @value side stores an enum type that represents which player is to play
  */
  private Side side;

 /**
  * This is a constructor that creates a game board specific to the XiangQi game
  */
  public Xiangqi(){
    //defines that the North player has the first move//
    side = Side.NORTH;
    xiangqiDisplay = new XiangqiDisplay();
    //creates the XiangQi chessboard//
    chessBoard = new ChessBoard(10,9, xiangqiDisplay, this);
    //adds all the pieces to the board at the appropriate starting locations//
    chessBoard.addPiece(new KingPiece(Color.RED), 0, 4);
    chessBoard.addPiece(new KingPiece(Color.WHITE), 9, 4);
    chessBoard.addPiece(new GuardPiece(Color.RED), 0 , 3);
    chessBoard.addPiece(new GuardPiece(Color.RED), 0 , 5);
    chessBoard.addPiece(new GuardPiece(Color.WHITE), 9 , 3);
    chessBoard.addPiece(new GuardPiece(Color.WHITE), 9 , 5);
    chessBoard.addPiece(new ElephantPiece(Color.RED), 0, 2);
    chessBoard.addPiece(new ElephantPiece(Color.RED), 0, 6);
    chessBoard.addPiece(new ElephantPiece(Color.WHITE), 9, 2);
    chessBoard.addPiece(new ElephantPiece(Color.WHITE), 9, 6);
    chessBoard.addPiece(new KnightPiece(Color.RED), 0, 1);
    chessBoard.addPiece(new KnightPiece(Color.RED), 0, 7);
    chessBoard.addPiece(new KnightPiece(Color.WHITE), 9, 1);
    chessBoard.addPiece(new KnightPiece(Color.WHITE), 9, 7);
    chessBoard.addPiece(new RookPiece(Color.RED), 0, 0);
    chessBoard.addPiece(new RookPiece(Color.RED), 0, 8);
    chessBoard.addPiece(new RookPiece(Color.WHITE), 9, 0);
    chessBoard.addPiece(new RookPiece(Color.WHITE), 9, 8);
    chessBoard.addPiece(new CannonPiece(Color.RED), 2, 1);
    chessBoard.addPiece(new CannonPiece(Color.RED), 2, 7);
    chessBoard.addPiece(new CannonPiece(Color.WHITE), 7, 1);
    chessBoard.addPiece(new CannonPiece(Color.WHITE), 7, 7);
    chessBoard.addPiece(new PawnPiece(Color.RED), 3, 0);
    chessBoard.addPiece(new PawnPiece(Color.RED), 3, 2);
    chessBoard.addPiece(new PawnPiece(Color.RED), 3, 4);
    chessBoard.addPiece(new PawnPiece(Color.RED), 3, 6);
    chessBoard.addPiece(new PawnPiece(Color.RED), 3, 8);
    chessBoard.addPiece(new PawnPiece(Color.WHITE), 6, 0);
    chessBoard.addPiece(new PawnPiece(Color.WHITE), 6, 2);
    chessBoard.addPiece(new PawnPiece(Color.WHITE), 6, 4);
    chessBoard.addPiece(new PawnPiece(Color.WHITE), 6, 6);
    chessBoard.addPiece(new PawnPiece(Color.WHITE), 6, 8);
  }

 /**
  * This is a method that moves ChessPieces
  * @param piece is the piece to be moved
  * @param row is the row to move it tp
  * @param column is the column to move it to
  * @return a boolean that represents whether or not the move was successfully made
  */
  public boolean makeMove(ChessPiece piece, int row, int column){
    //checks if it is legal to play this piece at the current turn//
    if(legalPieceToPlay(piece)){
      //checks if destination square has a piece on it//
      if(piece.isLegalMove(row,column)){
        //checks if move is legal given that destination square is empty//
        if(piece.isLegalNonCaptureMove(row,column)){
          //removeRow is the row of the piece to be removed//
          int removeRow = piece.getRow();
          //removeColumn is the column of the piece to be removed//
          int removeColumn = piece.getColumn();
          //adds the piece to the new location on the chess board//
          chessBoard.addPiece(piece, row, column);
          //removes piece from old location on chess board//
          chessBoard.removePiece(removeRow, removeColumn);
          //represents that the move was successfully completed//
          piece.moveDone();
          //changes the value of side such that now it is the opponents turn//
          if(side == Side.NORTH){
            side = Side.SOUTH;
          }
          else{
            side = Side.NORTH;
          }
          return true;
        }
        
        else{
          return false;
        }
      }
      //if destination square is occupied//
      else{
        //checks if it is a legal capture move//
        if(piece.isLegalCaptureMove(row,column)){
          int removeRow = piece.getRow();
          int removeColumn = piece.getColumn();
          chessBoard.addPiece(piece, row, column);
          chessBoard.removePiece(removeRow, removeColumn);
          piece.moveDone();
          if(side == Side.NORTH){
            side = Side.SOUTH;
          }
          else{
            side = Side.NORTH;
          }
          return true;
        }
        else{  
          return false;
        }
      }
    }
    else{
      return false;
    }
    
  }
  
 /**
  * This is a method that checks if a player is trying to play out of turn
  * @param piece is the piece to be checked
  * @return a boolean if it is or is not the appropriate turn for the player to play
  */
  public boolean legalPieceToPlay(ChessPiece piece){
    //checks if side the piece is on is the same as the side the game is on//
    if(piece.getSide() == side){
      return true;
    }
    else{
      return false;
    }
  }
  
  public static void main( String[] args){
    new Xiangqi();
  }
}
  

    
    
  
  
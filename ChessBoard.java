
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;
import java.lang.*;

/**
 * @author Ananth Suresh
 * This class represents a default chess board
 */

public class ChessBoard implements ActionListener{
 /**
  * @value pieces is a 2D array of ChessPieces that stores all the Chess Pieces on the board
  */
  private ChessPiece[][] pieces;
 /**
  * @value grid is a 2D array of JButtons that stores all the buttons on the board
  */
  private JButton[][] grid;
 /**
  * @value numClick represents an integer value of whether it is the first or second click by the user
  */
  private int numClick = 0;
 /**
  * @value rowClicked is an integer that stores the row of the JButton that was clicked first
  */
  private int rowClicked = 0;
 /**
  * @value columnClicked is an integer that stores the column of the JButton that was clicked first
  */
  private int columnClicked = 0;
 /**
  * @value rowClicked2 is an integer that stores the row of the JButton that was clicked second
  */
  private int rowClicked2 = 0;
 /**
  * @value columnClicked2 is an integer that stores the row of the JButton that was clicked second
  */
  private int columnClicked2 = 0;
 /**
  * @value chessDisplay stores the specific ChessBoardDisplay that should be used by the ChessBoard
  */
  private ChessBoardDisplay chessDisplay;
 /**
  * @value chessVersion stores the variant of chess that is being played
  */
  private ChessGame chessVersion;

  
 /**
  * This is a constructor that creates a game board of the appropriate size, version, and graphics
  * @param rows is the number of rows in the chess board
  * @param columns is the number of columns in the chess board
  * @param display
  * @param version
  */
  public ChessBoard(int rows, int columns, ChessBoardDisplay display, ChessGame version){
    this.chessDisplay = display;
    this.chessVersion = version;
    
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch (Exception e) {
    }
    
    //board is a JPanel that stores the array of JButtons which represent the chess board//
    JPanel board = new JPanel(new GridLayout(rows,columns));
    //frame is the JFrame that contains the JPanel, board//
    JFrame frame = new JFrame();
    frame.getContentPane().add(board, "Center");
    //grid is a 2D array of JButtons//
    grid = new JButton[rows][columns];
    //loop which initialises the 2D array, stores a JButton in each element and adds an action listener to each button//
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        grid[i][j] = new JButton();
        grid[i][j].setName(i + " " +j);
        grid[i][j].addActionListener(this);
        board.add(grid[i][j]);
        chessDisplay.displayEmptySquare(grid[i][j], i, j);
      }
    }
    //pieces is a 2D array of Chess Pieces corresponding to the buttons//
    pieces = new ChessPiece[rows][columns];
    //sets the size of the board and makes it visible//
    frame.setSize(1000,1000);
    frame.setVisible(true);
  }
  
 /**
  * Adds input chess piece to speciified location on board 
  * @param piece is the chess piece to be added
  * @param row is the row the piece is to be added to
  * @param column is the column the piece is to be added to
  */
  public void addPiece(ChessPiece piece, int row, int column){
    //adds piece to array of ChessPieces in correct location//
    pieces[row][column] = piece;
    //sets the row field of the piece to reflect its position in the array//
    piece.setRow(row);
    //sets the column field of the piece to reflect its position in the array//
    piece.setColumn(column);
    //sets the chessboard that the piece is on to the current chessboard
    piece.setChessBoard(this);
    //calls the appropriate chessDisplay to provide the graphics for the newly filled square//
    chessDisplay.displayFilledSquare(grid[row][column], row, column, pieces[row][column]);
  }
  
 /**
  * Removes chess piece from speciified location on board 
  * @param row is the row the piece is to be removed from
  * @param column is the column the piece is to be removed from
  * @return returns the ChessPiece that was removed
  */
  public ChessPiece removePiece(int row, int column){
    //stores the  chessPiece to be removed in a variable, piece//
    ChessPiece piece = pieces[row][column];
    //removes the piece from the array//
    pieces[row][column] = null;
    //calls the appropriate chessDisplay to provide graphics for the now empty square//
    chessDisplay.displayEmptySquare(grid[row][column], row, column);
    return piece;
  }

 /**
  * tells us if there is a chess piece at a specified location
  * @param row is the row to check
  * @param column is the column to check
  * @return returns a boolean representing if there was a piece at specified location
  */
  public boolean hasPiece(int row, int column){
    //checks if piece exists in input location//
    if(pieces[row][column] == null){
      return false;
    }
    else{
      return true;
    }
  }
  
 /**
  * returns piece at specified location
  * @param row is the row to check
  * @param column is the column to check
  * @return returns piece at specified location
  */
  public ChessPiece getPiece(int row, int column){
    //checks if piece exists at location//
    if(pieces[row][column] != null){
      return pieces[row][column];
    }
    else{
      return null;
    }
  }
 
 /**
  * defines what happens when buttons are clicked, overrides inherited method stub from ActionListener interface
  * @param e represents the click of the button
  */
  @Override
  public void actionPerformed(ActionEvent e){
    //checks if it is the first click//
    if(numClick == 0){
      //b is the button that is clicked//
      JButton b = (JButton) e.getSource();
      //position is an array of Strings that contains the row and column in two elements//
      String[] position =((b.getName()).split(" "));
      //converts String representation of row value to int//
      rowClicked = Integer.parseInt(position[0]);
      //converts String representation of column value to int//
      columnClicked = Integer.parseInt(position[1]);
      //resets click count to 0 if button clicked on does not have a chess piece to be moved//
      if(pieces[rowClicked][columnClicked] == null){
        numClick = 0;
      }
      //if clicked button does have a chesspiece, highlights the square and increments numClicks//
      else{
        chessDisplay.highlightSquare(true, grid[rowClicked][columnClicked], rowClicked, columnClicked, pieces[rowClicked][columnClicked]);
        numClick += 1;
      }
    }
    
    //when it is the second click//  
    else{
      //b is the second button to be clicked//
      JButton b = (JButton) e.getSource();
      String[] position =((b.getName()).split(" "));
      rowClicked2 = Integer.parseInt(position[0]);
      columnClicked2 = Integer.parseInt(position[1]);  
      //removes highlight from first clicked square//
      chessDisplay.highlightSquare(false, grid[rowClicked][columnClicked], rowClicked, columnClicked, pieces[rowClicked][columnClicked]);
      //resets click counter//
      numClick = 0;
      //moves piece from first clicked box to second clicked box if it is legal by calling the makeMove method//
      chessVersion.makeMove(pieces[rowClicked][columnClicked], rowClicked2, columnClicked2);
    } 
  }
}
  
     
    
    
    
  
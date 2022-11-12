/*
 * This class codes for the JavaFX ChessBoard which when executed will show a chessboard with all the chesspieces of either European Chess
 * or Xiangqi Chess and adds the appropriate pieces to the right positions
 * Author: Mehlam Saifudeen
 */
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class JavaFXChessBoard extends Application implements ChessBoard
{
  private ChessGame chessGame;  // an instance for creating a chess of type ChessGame
  private ChessPiece[][] pieces;   // an instance for creating a double array of chesspieces
  private Button[][] buttons;  // a private field to create a double array of buttons
  private JavaFXChessBoardDisplay display;  // a private instance of type JavaFXChessBoardDisplay
  /*
   * This is an override of the start method of Application
   * @param primaryStage takes a stage to execute the chess board
   * */
  public void start(Stage primaryStage)
  {
    List<String> s = getParameters().getRaw();
    String sen = s.get(0);
    int row = 0;
    int column = 0;
    if(sen.equalsIgnoreCase("chess"))
    {
        display = new JavaFXEuropeanChessDisplay();
        chessGame = new EuropeanChess();
        row = 8;
        column = 8;
    }
    else
    {
        display = new JavaFXXiangqiDisplay(10, 9);
        chessGame = new Xiangqi();
        row = 10; 
        column = 9;
    }
    buttons = new Button[row][column];
    pieces = new ChessPiece[row][column];
    GridPane gridPane = new GridPane();
    for(int i = 0; i<row; i++)
    {
      for(int j=0;j<column;j++)
      {
        buttons[i][j] = new Button();
        buttons[i][j].setOnAction(new ChessAction());
        display.displayEmptySquare(buttons[i][j], i, j);
        gridPane.add(buttons[i][j], i , j);
        pieces[i][j] = null;
      }
    }
    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    chessGame.startGame(this);
    primaryStage.show();
  }
  
  @Override
  public ChessGame getGameRules() {
    return chessGame;
  }
  
  /**
   * Changes the rules of the game
   * @param newRules the new rules for the game
   */
  public void setGameRules(ChessGame newRules) {
    this.chessGame = newRules;
  }
  
  /**
   * Returns the number of rows in the board.
   * @return the number of rows
   */
  public final int numRows() {
    return buttons.length;
  }
  
  /**
   * Returns the number of columns in the board.
   * @return the number of columns
   */
  public final int numColumns() {
    return buttons[0].length;
  }
  
  /**
   *  Adds a piece to the board at the desired location.  Any piece currently
   *  at that location is lost.
   *  @param piece   the piece to add
   *  @param row     the row for the piece
   *  @param col     the column for the piece
   */
  @Override
  public void addPiece(ChessPiece piece, int row, int column) 
  {
    // set the piece on the board, tell the piece where it is, and then use the display rules to display the square
    // run the display code on the event dispatch thread
    pieces[row][column] = piece;
    piece.setLocation(row, column);
    display.displayFilledSquare(buttons[row][column], row, column, piece);    
  }
  
  /**
   *  Removes a piece from the board
   *  @param row  the row of the piece
   *  @param col  the column of the piece
   *  @return  the piece removed of null if there was no piece at that square
   */
  @Override
  public ChessPiece removePiece(int row, int column) {
    // remove the piece from the board, use the display rules to show an empty square,
    // and run the display code on the event dispatch thread
    ChessPiece save = pieces[row][column];
    pieces[row][column] = null;
    display.displayEmptySquare(buttons[row][column], row, column);
    return save;
  }
  
  /**
   *  Returns true if there is a piece at a specific location of the board.
   *  @param row   the row to examine
   *  @param col   the column to examine
   *  @return   true if there is a piece a this row and column and false
   *            if the square is empty
   */
  @Override
  public boolean hasPiece(int row, int column) {
    return (pieces[row][column] != null);
  }
  
  /**
   * Returns true if a particular square is threatened by an opposing piece.
   * @param row     the row of the square
   * @param column  the column of the square
   * @param piece   a piece of the game
   * @return  true if the square can be attacked by a piece of an opposing side as the parameter piece
   */
  public boolean squareThreatened(int row, int column, ChessPiece piece) {
    for (int i = 0; i < buttons.length; i++) {
      for (int j = 0; j < buttons[i].length; j++) {
        if (hasPiece(i,j) && getPiece(i, j).getSide() != piece.getSide() &&
            getPiece(i, j).isLegalMove(row, column))
          return true;
      }
    }
    return false;
  }
  
  /**
   *  Returns the chess piece at a specific location on the board.
   *  @param row   the row for the piece
   *  @param col   the column for the piece
   *  @return      the piece at the row and column or null if there is no piece there.
   */
  public ChessPiece getPiece(int row, int col) 
  {
    return pieces[row][col];
  }
  
  /** The code the responds when the user clicks on the game board */
  private class ChessAction implements EventHandler<ActionEvent> {
    private boolean firstPick = true;  // if true, we a selecting a piece
    private int pieceRow;              // remember row of selected piece
    private int pieceCol;              // remember column of selected piece
    
    /** 
     * What we do when the user chooses the piece to move.
     * @param row the row of the chosen piece
     * @param col the column of the chosen piece
     */
    private void processFirstSelection(int row, int column) {
      if ((pieces[row][column] != null) && 
          (getGameRules() == null || getGameRules().legalPieceToPlay(pieces[row][column], row, column))) {
        /*
         * if this is the first pick and a square with a piece was picked,
         * remember the piece's location and highlight the square.
         */
        pieceRow = row;
        pieceCol = column;
        display.highlightSquare(true, buttons[row][column], row, column, pieces[row][column]);
        firstPick = false;
      }
    }
    
    /**
     * What we do when the user chooses the square to move the piece to.
     * @param row the row the piece will move to
     * @param col the column the piece will move to
     */
    private void processSecondSelection(int row, int column) {
      if (row == pieceRow && column == pieceCol)
        return;
      
      boolean moveMade = getGameRules().makeMove(pieces[pieceRow][pieceCol], row, column);
      
      // if the move was made or if it was not made and the user select a new piece, then reset to choose a new move
      if (moveMade || getGameRules().canChangeSelection(pieces[pieceRow][pieceCol], pieceRow, pieceCol)) {
        display.highlightSquare(false, buttons[pieceRow][pieceCol], pieceRow, pieceCol, pieces[pieceRow][pieceCol]);
        firstPick = true;
      }
    }
    
    /**
     *  Handle a button click.  The method alternates between selecting a piece
     *  and selecting any square.  After both are selected, the piece's 
     *  legalMove is called, and if the move is legal, the piece is moved.
     *  @param e   the event that triggered the method
     */
    public void handle(ActionEvent e) {
      Button b = (Button)e.getSource();
      int col = -1;
      int row = -1;
      
      // first find which button (board square) was clicked.
      for (int i = 0; i < buttons.length; i++) {
        for (int j = 0; j < buttons[i].length; j++) {
          if (buttons[i][j] == b) {
            row = i;
            col = j;
          }
        }
      }
      
      if (firstPick) {
        processFirstSelection(row, col);
      }
      else {
        processSecondSelection(row, col);
      }
    }
  }
    public static void main(String[] args)
    {
      Application.launch(args);
    }
  
}

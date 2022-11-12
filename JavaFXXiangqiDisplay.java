import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
public class JavaFXXiangqiDisplay implements JavaFXChessBoardDisplay{
  
 /**
  * This is a constructor that creates the XiangQiDisplay
  */
  private int numRows = 10;
  private int numColumns = 9;
  /** The primary color of the checkerboard */
  public static Color lightGray = Color.LIGHTGRAY;
  
  /** The secondary color of the checkerboard */
  public static Color blackColor = Color.BLACK;
  
  /* The color of the SOUTH player */
  public static Color southPlayerColor = Color.YELLOW;
  
  /* The color of the NORTH player */
  public static Color northPlayerColor = Color.GREEN;
  
  /* The color of the EAST player */
  public static Color eastPlayerColor = Color.WHITE;
  
  /* The color of the WEST player */
  public static Color westPlayerColor = Color.GRAY;
  
  /** The color used to highlight a square */
  public static Color highlightColor = Color.BLUE;
  
  public JavaFXXiangqiDisplay(int row, int column)
  {
    row = this.numRows;
    column = this.numColumns;
  }
  
 /**
  * This is a method that defines the visuals for an empty square
  * @param button is the button whose graphics will be modified
  * @param row is the row of the empty square
  * @param column is the column of the empty square
  */
  @Override
  public void displayEmptySquare(Button button, int row, int column)
  {
    button.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    button.setText(null);
  }
  
 /**
  * This is a method that defines the visuals for an filled square
  * @param button is the button whose graphics will be modified
  * @param row is the row of the filled square
  * @param column is the column of the filed square
  */
  @Override
  public void displayFilledSquare(Button button, int row, int column, ChessPiece chessPiece)
  {
    Color pieceColor = Color.BLUE;
    switch(chessPiece.getSide())
    {
      case NORTH: pieceColor = northPlayerColor;
      break;
      case SOUTH: pieceColor = southPlayerColor;
      break;
      case WEST: pieceColor = westPlayerColor;
      break;
      case EAST: pieceColor = eastPlayerColor;
      break;
    }
    button.setBackground(new Background(new BackgroundFill(pieceColor, new CornerRadii(10), new Insets(15))));
    button.setText(chessPiece.getLabel());
  }
  
  
 /**
  * This is a method that overrides ChessBoard display's highlight method
  * @param highlight represents whether the highlight is on or off
  * @param button is the button to be highlighted
  * @param row is the row of the JButton
  * @param column is the column of the JButton
  * @param chessPiece is the piece located on that square
  */
  @Override
  public void highlightSquare(boolean highlight, Button button, int row, int column, ChessPiece chessPiece)
  {
    if(highlight)
    {
      button.setBackground(new Background(new BackgroundFill(highlightColor, new CornerRadii(10), new Insets(15))));
    }
    else if(chessPiece == null)
    {
      displayEmptySquare(button, row, column);
    }
    if(highlight)
    {
      displayFilledSquare(button, row, column, chessPiece);
    }
  } 
}
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.Toolkit;
import java.awt.Color;

public class SwingXiangqiDisplay implements SwingChessBoardDisplay
{
  /** The primary color of the checkerboard */
  public static Color redColor   = Color.red;
  
  /** The secondary color of the checkerboard */
  public static Color blackColor = Color.black;
  
  /* The color of the SOUTH player */
  public static Color southPlayerColor = Color.yellow;
  
  /* The color of the NORTH player */
  public static Color northPlayerColor = Color.green;
  
  /* The color of the EAST player */
  public static Color eastPlayerColor = Color.white;
  
  /* The color of the WEST player */
  public static Color westPlayerColor = Color.gray;
  
  /** The color used to highlight a square */
  public static Color highlightColor = Color.blue;
  
 /**
  * This is a constructor that creates the XiangQiDisplay
  */
  public SwingXiangqiDisplay(){
  }
  
 /**
  * This is a method that defines the visuals for an empty square
  * @param emptySquare is the button whose graphics will be modified
  * @param row is the row of the empty square
  * @param column is the column of the empty square
  */
  public void displayEmptySquare(JButton emptySquare, int row, int column){
    //sets the background color to gray//
    emptySquare.setBackground(Color.gray);
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
  public void displayFilledSquare(JButton button, int row, int column, ChessPiece chessPiece){
      Color pieceColor;
    
    switch (chessPiece.getSide()) {
      case NORTH:   pieceColor = northPlayerColor;
                    break;
      case SOUTH:   pieceColor = southPlayerColor;
                    break;
      case EAST:    pieceColor = eastPlayerColor;
                    break;
      default:      pieceColor = westPlayerColor;
    }
    
    button.setBackground(pieceColor);
    button.setText(chessPiece.getLabel());
    button.setIcon((Icon)chessPiece.getIcon());
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
      square.setBackground(Color.blue);
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
  

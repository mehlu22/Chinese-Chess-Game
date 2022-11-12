public class XiangqiKingPiece extends ChessPiece
{
  
 // field to store the label of the piece
  private final String label = "X";
  
  // field to store the icon of the piece
  private final Object icon = null;
  
  // field to store which player the piece belongs to
  private ChessGame.Side side;
  
  // field to store the piece itself
  private ChessPiece piece;
  
  /* constructor to inherit values for label, row and column to move to, side to which piece belongs and the chessboard 
   * from the chesspiece class*/
    public XiangqiKingPiece(String label ,int toRow, int toColumn, ChessGame.Side side,SwingChessBoard chessBoard)
    {
        super(label,toRow,toColumn,side,chessBoard);
        //this.icon = icon;
    }

    // method to return the icon of the piece
    public Object getIcon()
    {
        return icon;
    }

    // method to return the label of the piece
    public String getLabel()
    {
        return label;
    }
    
 /**
  * This is a checks if it is a legal non capture move for the piece
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */ 
  public boolean isNonLegalCaptureMove(int row, int column){
    if(getSide() == side.NORTH){
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
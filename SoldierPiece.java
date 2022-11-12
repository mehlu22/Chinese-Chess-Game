public class SoldierPiece extends ChessPiece
{
 
  // field to store the label of the piece
  private final String label = "S";
  
  // field to store the icon of the piece
  private final Object icon = null;
  
  // field to store which player the piece belongs to
  private ChessGame.Side side;
  
  // field to store the piece itself
  private ChessPiece piece;
  
  /* constructor to inherit values for label, row and column to move to, side to which piece belongs and the chessboard 
   * from the chesspiece class*/
    public SoldierPiece(String label ,int toRow, int toColumn, ChessGame.Side side,SwingChessBoard chessBoard)
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
      //checks if before halfway//
      if(getRow() < 5){
        if(rowDiff(row) > 1){
          return false;
        }
        else{
          if(columnDiff(column) > 0){
            return false;
          }
          else if (rowDiff(row) == 1 && columnDiff(column) == 1){
            return false;
          }
          else{
            return true;
          }
        }
      }
      //after halfway//
      else{
        if(rowDiff(row) > 1){
          return false;
        }
        else{
          if(columnDiff(column) > 1){
            return false;
          }
          else if (rowDiff(row) == 1 && columnDiff(column) == 1){
            return false;
          }
          else{
            return true;
          }
        }
      }
    }
    //if on the other side//
    else{
      if(getRow() > 4){
        if(rowDiff(row) > 1){
          return false;
        }
        else{
          if(columnDiff(column) > 0){
            return false;
          }
          else if (rowDiff(row) == 1 && columnDiff(column) == 1){
            return false;
          }
          else{
            return true;
          }
        }
      }
      else{
        if(rowDiff(row) > 1){
          return false;
        }
        else{
          if(columnDiff(column) > 1){
            return false;
          }
          else if (rowDiff(row) == 1 && columnDiff(column) == 1){
            return false;
          }
          else{
            return true;
          }
        }
      }
    }
  }      
}

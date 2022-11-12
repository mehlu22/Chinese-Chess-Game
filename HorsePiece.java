public class HorsePiece extends ChessPiece
{
 
 // field to store the label of the piece
  private final String label = "H";
  
  // field to store the icon of the piece
  private final Object icon = null;
  
  // field to store which player the piece belongs to
  private ChessGame.Side side;
  
  // field to store the piece itself
  private ChessPiece piece;
  
  /* constructor to inherit values for label, row and column to move to, side to which piece belongs and the chessboard 
   * from the chesspiece class*/
    public HorsePiece(String label ,int toRow, int toColumn, ChessGame.Side side,SwingChessBoard chessBoard)
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
  * This overrides the existing rowDiff method to provide negative values
  * @param row is the row the piece is to be moved to 
  * @return an integer representing the number and direction of rows moved
  */
  public int rowDiff(int row){
    return row - getRow();
  }
  
 /**
  * This overrides the existing columnDiff method to provide negative values
  * @param column is the column the piece is to be moved to 
  * @return an integer representing the number and direction of columns moved
  */
  public int columnDiff(int column){
    return column - getColumn();
  }
  
 /**
  * This method checks if movement is in a legal L shape
  * @param row is the row the piece is to be moved to 
  * @param column is the column the piece is to be moved to
  * @return a boolean representing if the move is legal
  */
  public boolean isL(int row, int column){
    //checks for all possible L combinations//
    if((column - getColumn() == 1) && (row - getRow() == 1)){
      return true;
    }
    else if(column - getColumn() == 1 && row - getRow() == -1){
      return true;
    }
      
    else if((column - getColumn() == -1) && ((row - getRow() == 1))){
      return true;
    }
    else if((column - getColumn() == -1) && ((row - getRow() == -1))){
      return true;
    }
      
    else if((column - getColumn() == 1) && ((row - getRow() == -1))){
      return true;
    }
    
    else if((column - getColumn() == 1) && ((row - getRow() == 1))){
      return true;
    }
    
    else if((column - getColumn() == -1) && ((row - getRow() == -1))){ 
      return true;
    }
    else if((column - getColumn() == -1) && ((row - getRow() == 1))){ 
      return true;
    }
    else{
      return false;
    }
  }

 /**
  * This is a checks if it is a legal non capture move for the piece
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */ 
  public boolean isNonLegalCaptureMove(int row, int column){
    //checks if L shape move//
    if(isL(row, column)){
      return true;
    }
    else{
      return false;
    }
  } 
}
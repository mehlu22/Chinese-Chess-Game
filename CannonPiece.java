public class CannonPiece extends ChessPiece
{
  // field to store the label of the piece
  private final String label = "C";
  
  // field to store the icon of the piece
  private final Object icon = null;
  
  // field to store which player the piece belongs to
  private ChessGame.Side side;
  
  // field to store the piece itself
  private ChessPiece piece;
  
  /* constructor to inherit values for label, row and column to move to, side to which piece belongs and the chessboard 
   * from the chesspiece class*/
    public CannonPiece(String label ,int toRow, int toColumn, ChessGame.Side side,SwingChessBoard chessBoard)
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
  * This overrides the isLegalMove in ChessPiece
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */ 
    @Override
  public boolean isLegalMove(int row, int column){
    //if there is a piece on destination square//
    if((this.getChessBoard().getPiece(row,column)) == null){
      return true;
    }
    else{
      return false;
    }

  } 
      
  
 /**
  * This is a checks if it is a legal non capture move for the piece
  * has the same method as Rook
  * @param row is the row that the piece is moved to
  * @param column is the column that the piece is moved to
  * @return boolean that tells us if it is legal
  */ 
  @Override
  public boolean isNonLegalCaptureMove(int row, int column){
    int freeSquare = 0;
    if(columnDiff(column) > 0 && rowDiff(row) > 0){
      return false;
    }
    else{
      if(columnDiff(column) > 0){
        if(column > getColumn()){
          for(int i = getColumn() + 1; i <= column; i++){
            if(getChessBoard().getPiece(getRow(),i) == null){
              freeSquare++;
            }
          }
          if(freeSquare== columnDiff(column)){
            return true;
          }
          else{
            return false;
          }
        }
        else{
          for(int i = getColumn() - 1; i >= column; i--){
            if(getChessBoard().getPiece(getRow(),i) == null){
              freeSquare++;
            }
          }
          if(freeSquare== columnDiff(column)){
            return true;
          }
          else{
            return false;
          }
        }
      }
      else{
        if(row > getRow()){
          for(int i = getRow() + 1; i <= row; i++){
            if(getChessBoard().getPiece(i,getColumn()) == null){
              freeSquare++;
            }
          }
          if(freeSquare== rowDiff(row)){
            return true;
          }
          else{
            return false;
          }
        }
        else{
          for(int i = getRow() - 1; i >= row; i--){
            if(getChessBoard().getPiece(i,getColumn()) == null){
              freeSquare++;
            }
          }
          if(freeSquare== rowDiff(row)){
            return true;
          }
          else{
            return false;
          }
        }
      }
    }
  }
  
  /**
   * This is a checks if it is a legal capture move for the piece and overrides the default
   * @param row is the row that the piece is moved to
   * @param column is the column that the piece is moved to
   * @return boolean that tells us if it is legal
   */ 
  
  @Override  
  public boolean isLegalCaptureMove(int row, int column){
    int occupiedSquare = 0; 
    
    if(this.getSide() == (this.getChessBoard().getPiece(row,column)).getSide()){
      return false;
    }
    else{
      if(columnDiff(column) > 0 && rowDiff(row) > 0){
        return false;
      }
      else{
        if(columnDiff(column) > 0){
          if(column > getColumn()){
            for(int i = getColumn() + 1; i < column; i++){
              if(getChessBoard().getPiece(getRow(),i) != null){
                occupiedSquare += 1;
              }
            }
            if(occupiedSquare == 1){
              return true;
            }
            else{
              return false;
            }
          }
          else{
            for(int i = getColumn() - 1; i > column; i--){
              if(getChessBoard().getPiece(getRow(),i) != null){
                occupiedSquare += 1;
              }
            }
            if(occupiedSquare == 1){
              return true;
            }
            else{
              return false;
            }
          }
        }
        else{
          if(row > getRow()){
            for(int i = getRow() + 1; i < row; i++){
              if((getChessBoard().getPiece(i,getColumn())) != null){
                occupiedSquare += 1;
              }
            }
            if(occupiedSquare == 1){
              return true;
            }
            else{
              return false;
            }
          }
          else{
            for(int i = getRow() - 1; i > row; i--){
              if(getChessBoard().getPiece(i,getColumn()) != null){
                occupiedSquare += 1;
              }
            }
            if(occupiedSquare ==  1){
              return true;
            }
            else{
              return false;
            }
          }
        }
      }
    }
  }
  
  
}

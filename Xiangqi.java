/* This class  implements the chessgame interface, all the movement interfaces.
 * It allows the piece of a only that player whose turn it is to be selected on the chessboard
 * It also checks if a move is legal and if true the piece is moved on the board, and the turn changes so it is the next players turn */
public class Xiangqi implements ChessGame{
  
  /**
  * @value chessBoard is a variable that stores the Xiangqi chessBoard
  */
  private ChessBoard chessBoard;
  /**
  * @value xiangqiDisplay stores the graphics for the Xiangqi game
  */
  private JavaFXXiangqiDisplay xiangqiDisplay;
  /**
  * @value side stores an enum type that represents which player is to play
  */
  private ChessGame.Side turn = Side.NORTH;
  
  /**
  * This is a constructor that creates a game board specific to the XiangQi game
  */
  
  private ChessGame game;
  
  private int numColumns = 9;
  
  private int numRows = 10;
  
  
  /**
  * This is a method that moves ChessPieces
  * @param piece is the piece to be moved
  * @param row is the row to move it tp
  * @param column is the column to move it to
  * @return a boolean that represents whether or not the move was successfully made
  */
  /*@Override
   public boolean makeMove(ChessPiece piece, int toRow, int toColumn){
  //checks if it is legal to play this piece at the current turn//
    if(legalPieceToPlay(piece, toRow, toColumn)){
    //checks if destination square has a piece on it//
      if(piece.isLegalMove(toRow,toColumn)){
      //checks if move is legal given that destination square is empty//
        if(piece.isNonLegalCaptureMove(toRow,toColumn)){
        //removeRow is the row of the piece to be removed//
          int removeRow = piece.getRow();
          //removeColumn is the column of the piece to be removed//
          int removeColumn = piece.getColumn();
          //adds the piece to the new location on the chess board//
          chessBoard.addPiece(piece, toRow, toColumn);
          //removes piece from old location on chess board//
          chessBoard.removePiece(removeRow, removeColumn);
          //represents that the move was successfully completed//
          piece.moveDone();
          //changes the value of side such that now it is the opponents turn//
          if(turn == Side.NORTH){
          turn = Side.SOUTH;
            }
          else{
          turn = Side.NORTH;
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
        if(piece.isLegalCaptureMove(toRow,toColumn)){
        int removeRow = piece.getRow();
          int removeColumn = piece.getColumn();
          chessBoard.addPiece(piece, toRow, toColumn);
          chessBoard.removePiece(removeRow, removeColumn);
          piece.moveDone();
          if(turn == Side.NORTH){
          turn = Side.SOUTH;
            }
          else{
          turn = Side.NORTH;
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
    
    }*/
  
  // This method which create the functions to allow the pieces to move around teh chessboard by adding, removing and replacing pieces at indicated positions
  public boolean makeMove(ChessPiece piece, int toRow, int toColumn)
  {
    if(piece.isLegalMove(toRow, toColumn))
    {
      piece.getChessBoard().removePiece(toRow, toColumn);
      piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
      piece.getChessBoard().addPiece(piece, toRow, toColumn);
      piece.setLocation(toRow, toColumn);
      moveDone();
      return true;
    }
    return false;
  }
  
  /**
  * This is a method that checks if a player is trying to play out of turn
  * @param piece is the piece to be checked
  * @return a boolean if it is or is not the appropriate turn for the player to play
  */
  @Override
 public boolean legalPieceToPlay(ChessPiece piece, int row, int column){
   //checks if side the piece is on is the same as the side the game is on//
   if(piece.getSide() == turn){
      return true;
    }
    else{
      return false;
    }
  }
 
 // Method that returns which players turn it is
 public ChessGame.Side getTurn()
 {
   return this.turn;
 }
 
 // Method that sets which player's turn it is
 public void setTurn(ChessGame.Side turn)
 {
   this.turn = turn;
 }
 
 public ChessGame getGame()
 {
   return game;
 }
 public void moveDone()
 {
   if(Side.NORTH == getTurn())
   {
     setTurn(Side.SOUTH);
   }
   else
   {
     setTurn(Side.NORTH);
   }
 }
 
 @Override
 public void startGame(ChessBoard board)
 {
   ;
 }
 
 @Override
 public int getNumRows()
 {
   return numColumns;
 }
 
 @Override
 public int getNumColumns()
 {
   return numRows;
 }
}
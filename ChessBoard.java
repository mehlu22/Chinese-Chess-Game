/* 
 * An interface ChessBoard with method stubs that are overriden in the JavaFXChessBoard and SwingChessBoard classes
 * Author Mehlam Saifudeen
 * */
public interface ChessBoard
{
  public ChessGame getGameRules();
  
  public void addPiece(ChessPiece piece, int row, int column);
  
  public ChessPiece removePiece(int row, int column);
  
  public boolean hasPiece(int row, int column);
  
  public ChessPiece getPiece(int row, int column);
  
}
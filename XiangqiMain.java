/* Creates a main class that launches the game by creating a chessboard with all the individual chess pieces on their starting positions. 
 * The game is ready to be started */
import java.util.*;
import javax.swing.*;
public class XiangqiMain
{
  public static void main(String args[])
  {
    SwingChessBoard board = new SwingChessBoard(new SwingXiangqiDisplay(), new Xiangqi());
    ChessPiece piece1 = new XiangqiKingPiece("X", 0,4, ChessGame.Side.NORTH, board);
    ChessPiece piece2 = new XiangqiKingPiece("X", 9,4, ChessGame.Side.SOUTH, board);
    ChessPiece piece3 = new GuardPiece("G", 0,3,ChessGame.Side.NORTH, board);
    ChessPiece piece4 = new GuardPiece("G", 0,5, ChessGame.Side.NORTH, board);
    ChessPiece piece5 = new GuardPiece("G", 9,3, ChessGame.Side.SOUTH, board);
    ChessPiece piece6 = new GuardPiece("G", 9,5, ChessGame.Side.SOUTH, board);
    ChessPiece piece7 = new ElephantPiece("E", 0,2, ChessGame.Side.NORTH, board);
    ChessPiece piece8 = new ElephantPiece("E", 0,6, ChessGame.Side.NORTH, board);
    ChessPiece piece9 = new ElephantPiece("E", 9,2, ChessGame.Side.SOUTH, board);
    ChessPiece piece10 = new ElephantPiece("E", 9,6, ChessGame.Side.SOUTH, board);
    ChessPiece piece11 = new HorsePiece("H", 0,1, ChessGame.Side.NORTH, board);
    ChessPiece piece12 = new HorsePiece("H", 0,7, ChessGame.Side.NORTH, board);
    ChessPiece piece13 = new HorsePiece("H", 9,1, ChessGame.Side.SOUTH, board);
    ChessPiece piece14 = new HorsePiece("H", 9,7, ChessGame.Side.SOUTH, board);
    ChessPiece piece15 = new RookPiece("R", 0,0, ChessGame.Side.NORTH, board);
    ChessPiece piece16 = new RookPiece("R", 0,8, ChessGame.Side.NORTH, board);
    ChessPiece piece17 = new RookPiece("R", 9,0, ChessGame.Side.SOUTH, board);
    ChessPiece piece18 = new RookPiece("R", 9,8, ChessGame.Side.SOUTH, board);
    ChessPiece piece19 = new CannonPiece("C", 2,1,ChessGame.Side.NORTH, board);
    ChessPiece piece20 = new CannonPiece("C", 2,7, ChessGame.Side.NORTH, board);
    ChessPiece piece21 = new CannonPiece("C", 7,1, ChessGame.Side.SOUTH, board);
    ChessPiece piece22 = new CannonPiece("C", 7,7, ChessGame.Side.SOUTH, board);
    ChessPiece piece23 = new SoldierPiece("S", 3,0, ChessGame.Side.NORTH, board);
    ChessPiece piece24 = new SoldierPiece("S", 3,2, ChessGame.Side.NORTH, board);
    ChessPiece piece25 = new SoldierPiece("S", 3,4, ChessGame.Side.NORTH, board);
    ChessPiece piece26 = new SoldierPiece("S", 3,6, ChessGame.Side.NORTH, board);
    ChessPiece piece27 = new SoldierPiece("S", 3,8, ChessGame.Side.NORTH, board);
    ChessPiece piece28 = new SoldierPiece("S", 6,0, ChessGame.Side.SOUTH, board);
    ChessPiece piece29 = new SoldierPiece("S", 6,2, ChessGame.Side.SOUTH, board);
    ChessPiece piece30 = new SoldierPiece("S", 6,4, ChessGame.Side.SOUTH, board);
    ChessPiece piece31 = new SoldierPiece("S", 6,6,ChessGame.Side.SOUTH, board);
    ChessPiece piece32 = new SoldierPiece("S", 6,8, ChessGame.Side.SOUTH, board);
  }
}
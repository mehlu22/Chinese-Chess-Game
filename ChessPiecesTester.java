import org.junit.*;
import static org.junit.Assert.*;

/**
 * A class that tests the methods of the ChessPiece class.
 */
public class ChessPiecesTester{
   SwingChessBoard board = new SwingChessBoard(8, 8, new SwingEuropeanChessDisplay(), new EuropeanChess());
   Queen q = new Queen("Q", ChessGame.Side.NORTH, board, 3, 2);
   Rook r = new Rook("R", ChessGame.Side.NORTH, board, 3, 7);
   Bishop b = new Bishop("B", ChessGame.Side.NORTH, board, 5,2);
   Knight kn = new Knight("Kn", ChessGame.Side.NORTH, board, 4,5);
   King k = new King("K", ChessGame.Side.NORTH, board, 1,4);
   Pawn p = new Pawn("P", ChessGame.Side.NORTH, board, 1,0);
   Pawn p1 = new Pawn("P", ChessGame.Side.SOUTH, board, 6,7);
   
   Queen q1 = new Queen("Q", ChessGame.Side.SOUTH, board, 4, 1);
   Queen q2 = new Queen("Q", ChessGame.Side.NORTH, board, 4, 3);
   Pawn p2 = new Pawn("P", ChessGame.Side.NORTH, board, 5,6);
   Pawn p3 = new Pawn("P", ChessGame.Side.SOUTH, board, 2,4);
   
   
   
   
   @Test
   public void getChessBoard(){
     assertEquals("Testing get chess board", board, q.getChessBoard());
   }
   
   @Test
   public void getPosition(){
     //test get row
     assertEquals("Testing get row", 3, q.getRow());
     
     //test get column
     assertEquals("Testing get column", 2, q.getColumn());
   }
   
  //Legal verticle move test
   @Test
   public void VerticleMoveTest(){
     assertEquals("Testing legal verticle move south direction", true, q.legalVerticleMove(5, 2));
     assertEquals("Testing legal verticle move north direction", true, q.legalVerticleMove(2, 2));
     assertEquals("Testing illegal verticle move north direction", false, q.legalVerticleMove(4, 0));
   }
  //Legal horizontal move test
   @Test
   public void HorizontaleMoveTest(){
     assertEquals("Testing legal horizontal move west direction", true, q.legalHorizontalMove(3, 0));
     assertEquals("Testing legal horizontal move east direction", true, q.legalHorizontalMove(3, 7));
     assertEquals("Testing illegal horizontal move north direction", false, q.legalHorizontalMove(4, 0));
   }
  
  //Legal diagonal move test
   @Test
   public void DiagonalMoveTest(){
     assertEquals("Testing legal diagonal move downward west direction", true, q.legalDiagonalMove(4, 1));
     assertEquals("Testing legal diagonal move downward east direction", true, q.legalDiagonalMove(5, 4));
     assertEquals("Testing legal diagonal move upward east direction", true, q.legalDiagonalMove(2, 3));
     assertEquals("Testing legal diagonal move upward east direction", true, q.legalDiagonalMove(2, 1));
     assertEquals("Testing illegal diagonal move north direction", false, q.legalDiagonalMove(4, 0));
   }
  

   @Test
   public void legalNonCaptureMove(){
     //legal non-capture move for Queen test
     assertEquals("Testing legal non capture queen move", true, q.isLegalNonCaptureMove(6, 5));
     assertEquals("Testing legal non capture queen move", true, q.isLegalNonCaptureMove(7, 2));
     assertEquals("Testing legal non capture queen move", true, q.isLegalNonCaptureMove(3, 4));
     assertEquals("Testing legal non capture queen move", false, q.isLegalNonCaptureMove(6, 1));
     
     //legal non-capture move for Rook test
     assertEquals("Testing legal non capture rook move", true, r.isLegalNonCaptureMove(3, 4));
     assertEquals("Testing legal non capture rook move", true, r.isLegalNonCaptureMove(5, 7));
     assertEquals("Testing legal non capture rook move", false, r.isLegalNonCaptureMove(6, 1));
     
     //legal non-capture move for Bishop test
     assertEquals("Testing legal non capture bishop move", true, b.isLegalNonCaptureMove(7, 0));
     assertEquals("Testing legal non capture bishop move", true, b.isLegalNonCaptureMove(2, 5));
     assertEquals("Testing legal non capture bishop move", false, b.isLegalNonCaptureMove(6, 0));
     
     //legal non-capture move for Knight test
     assertEquals("Testing legal non capture knight move", true, kn.isLegalNonCaptureMove(2, 4));
     assertEquals("Testing legal non capture knight move", true, kn.isLegalNonCaptureMove(2, 6));
     assertEquals("Testing legal non capture knight move", true, kn.isLegalNonCaptureMove(6, 4));
     assertEquals("Testing legal non capture knight move", true, kn.isLegalNonCaptureMove(6, 6));
     assertEquals("Testing legal non capture knight move", false, kn.isLegalNonCaptureMove(3, 1));
     
     //legal non-capture move for King test
     assertEquals("Testing legal non capture king move", true, k.isLegalNonCaptureMove(2, 3));
     assertEquals("Testing legal non capture king move", true, k.isLegalNonCaptureMove(2, 5));
     assertEquals("Testing legal non capture king move", true, k.isLegalNonCaptureMove(0, 3));
     assertEquals("Testing legal non capture king move", true, k.isLegalNonCaptureMove(0, 5));
     assertEquals("Testing legal non capture king move", true, k.isLegalNonCaptureMove(0, 4));
     assertEquals("Testing legal non capture king move", true, k.isLegalNonCaptureMove(2, 4));
     assertEquals("Testing legal non capture king move", false, k.isLegalNonCaptureMove(3, 4));
     assertEquals("Testing legal non capture king move", false, k.isLegalNonCaptureMove(3, 6));
     assertEquals("Testing legal non capture king move", false, k.isLegalNonCaptureMove(3, 4));
     assertEquals("Testing legal non capture king move", false, k.isLegalNonCaptureMove(1, 2));
     
     //legal non-capture move for Pawn test
     assertEquals("Testing legal non capture pawn move", true, p.isLegalNonCaptureMove(2, 0));
     assertEquals("Testing legal non capture pawn move", true, p.isLegalNonCaptureMove(3, 0));
     assertEquals("Testing legal non capture pawn move", true, p1.isLegalNonCaptureMove(5, 7));
     assertEquals("Testing legal non capture pawn move", true, p1.isLegalNonCaptureMove(4, 7));
     assertEquals("Testing legal non capture pawn move", false, p.isLegalNonCaptureMove(4, 0));
   }
  
   

   @Test
   public void legalCaptureMove(){
     //legal capture move for Queen test
     assertEquals("Testing legal capture queen move", true, q.isLegalCaptureMove(4, 2));
     assertEquals("Testing illegal capture queen move", false, q.isLegalCaptureMove(4, 3));
   
    //legal capture move for Rook test
     assertEquals("Testing legal capture rook move", true, r.isLegalCaptureMove(6, 7));
  
     //legal capture move for Bishop test
     assertEquals("Testing legal capture bishop move", true, b.isLegalCaptureMove(4, 1));
  
     //legal capture move for Knight test
     assertEquals("Testing legal capture knight move", true, kn.isLegalCaptureMove(2, 4));
  
     //legal capture move for King test
     assertEquals("Testing legal capture king move", true, k.isLegalCaptureMove(2, 4));
  
     //legal capture move for Pawn test
     assertEquals("Testing legal capture pawn move", true, p1.isLegalCaptureMove(5, 6));
     assertEquals("Testing illegal capture pawn move", true, p2.isLegalCaptureMove(6, 5));
  }
}
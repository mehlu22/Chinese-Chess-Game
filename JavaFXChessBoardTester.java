import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class JavaFXChessBoardTester extends TestCase {
  
  /**
   * tests the constructor, addpiec, and hasPiece methods
   */
  public void testConstructor() {
    JavaFXChessBoard b = new JavaFXChessBoard (5, 5, new JavaFXXiangqiDisplay(), new Xiangqi());
    KingPiece k = new KingPiece(Color.RED);
    b.addPiece(k, 2, 2);
    assertTrue(b.hasPiece(2,2) == true);
    
  }
  
}

import junit.framework.TestCase;
import java.awt.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ChessBoardTester extends TestCase {
  
  /**
   * tests the constructor, addpiec, and hasPiece methods
   */
  public void testConstructor() {
    ChessBoard b = new ChessBoard (5, 5, new XiangqiDisplay(), new Xiangqi());
    KingPiece k = new KingPiece(Color.RED);
    b.addPiece(k, 2, 2);
    assertTrue(b.hasPiece(2,2) == true);
    
  }
  
}

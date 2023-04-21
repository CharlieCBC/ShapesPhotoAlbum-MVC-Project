import org.junit.Before;
import org.junit.Test;

import java.awt.Point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import model.Colour;
import model.Oval;
import model.Rectangle;
import model.ShapeAlbum;

/**
 * the test class for ShapeAlbum.
 */
public class ShapeAlbumTest {
  private ShapeAlbum shapeAlbum;
  private Oval oval;
  private Rectangle rectangle;

  /**
   * the setup for the test class.
   */
  @Before
  public void setUp() {
    shapeAlbum = new ShapeAlbum();
    oval = new Oval("Oval1", new Colour(255, 0, 0), new Point(10, 10), 20, 10);
    rectangle = new Rectangle("Rectangle1", new Colour(0, 255, 0), new Point(20, 20), 30, 40);
  }

  /**
   * the test for addShape.
   */
  @Test
  public void testAddShape() {
    shapeAlbum.addShape(oval);
    shapeAlbum.addShape(rectangle);
    assertEquals(2, shapeAlbum.getShapes().size());
  }

  /**
   * the test for removeShape.
   */
  @Test
  public void testRemoveShape() {
    shapeAlbum.addShape(oval);
    shapeAlbum.addShape(rectangle);
    shapeAlbum.removeShape(oval);
    assertEquals(1, shapeAlbum.getShapes().size());
    assertTrue(shapeAlbum.getShapes().contains(rectangle));
  }

  /**
   * the test for getShapes.
   */
  @Test
  public void testGetShapes() {
    shapeAlbum.addShape(oval);
    shapeAlbum.addShape(rectangle);
    assertEquals(2, shapeAlbum.getShapes().size());
    assertTrue(shapeAlbum.getShapes().contains(oval));
    assertTrue(shapeAlbum.getShapes().contains(rectangle));
  }

  /**
   * the test for reset.
   */
  @Test
  public void testReset() {
    shapeAlbum.addShape(oval);
    shapeAlbum.addShape(rectangle);
    shapeAlbum.reset();
    assertEquals(0, shapeAlbum.getShapes().size());
  }

  /**
   * the test for toString.
   */
  @Test
  public void testToString() {
    shapeAlbum.addShape(oval);
    shapeAlbum.addShape(rectangle);
    String expected = oval.toString() + "\n" + rectangle.toString() + "\n";
    assertEquals(expected, shapeAlbum.toString());
  }
}

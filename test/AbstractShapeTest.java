import model.AbstractShape;
import model.Colour;
import model.IShape;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * The test class for AbstractShape.
 */
public class AbstractShapeTest {
  private IShape shape;

  /**
   * Sets up the test fixture.
   */
  @Before
  public void setUp() {
    shape = new AbstractShape("TestShape", new Colour(100, 100, 100), new Point(10, 10), 50, 50) {
    };
  }

  /**
   * Tests the constructor.
   */
  @Test
  public void constructorInvalidArguments() {
    assertThrows(IllegalArgumentException.class, () ->
            new AbstractShape("", new Colour(100, 100, 100), new Point(10, 10), 50, 50) {
    });
    assertThrows(IllegalArgumentException.class, () ->
            new AbstractShape(null, new Colour(100, 100, 100), new Point(10, 10), 50, 50) {
    });
    assertThrows(IllegalArgumentException.class, () ->
            new AbstractShape("TestShape", new Colour(100, 100, 100), new Point(10, 10), 0, 50) {
    });
    assertThrows(IllegalArgumentException.class, () ->
            new AbstractShape("TestShape", new Colour(100, 100, 100), new Point(10, 10), 50, -1) {
    });
  }

  /**
   * Tests the getters and setters.
   */
  @Test
  public void getName() {
    assertEquals("TestShape", shape.getName());
  }

  /**
   * Tests the getters and setters.
   */
  @Test
  public void getColour() {
    assertEquals(new Colour(100, 100, 100), shape.getColour());
  }

  /**
   * Tests the getters and setters.
   */
  @Test
  public void setColour() {
    shape.setColour(new Colour(150, 150, 150));
    assertEquals(new Colour(150, 150, 150), shape.getColour());
  }

  /**
   * Tests the getters and setters.
   */
  @Test
  public void getPoint() {
    assertEquals(new Point(10, 10), shape.getPoint());
  }

  /**
   * Tests the getters and setters.
   */
  @Test
  public void getWidth() {
    assertEquals(50, shape.getWidth(), 0.0);
  }

  /**
   * Tests the getters and setters.
   */
  @Test
  public void getHeight() {
    assertEquals(50, shape.getHeight(), 0.0);
  }

  /**
   * Tests the getters and setters.
   */
  @Test
  public void setWidthAndHeight() {
    shape.setWidthAndHeight(100, 200);
    assertEquals(100, shape.getWidth(), 0.0);
    assertEquals(200, shape.getHeight(), 0.0);
  }

  /**
   * Tests the getters and setters.
   */
  @Test
  public void setWidthAndHeightInvalidArguments() {
    assertThrows(IllegalArgumentException.class, () -> shape.setWidthAndHeight(0, 50));
    assertThrows(IllegalArgumentException.class, () -> shape.setWidthAndHeight(50, -1));
  }

  /**
   * Tests the move method.
   */
  @Test
  public void move() {
    shape.move(20, 30);
    assertEquals(new Point(20, 30), shape.getPoint());
  }
}

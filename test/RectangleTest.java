import model.Colour;
import model.Rectangle;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Point;

import static org.junit.Assert.assertEquals;

/**
 * A class representing a test for the Rectangle class.
 */
public class RectangleTest {
  private Rectangle rectangle;

  /**
   * Sets up the test environment before each test.
   */
  @Before
  public void setUp() {
    rectangle = new Rectangle("myRectangle", new Colour(255, 0, 0), new Point(200, 200), 50, 100);
  }

  /**
   * Tests the constructor.
   */
  @Test
  public void testConstructor() {
    assertEquals("myRectangle", rectangle.getName());
    assertEquals(new Colour(255, 0, 0), rectangle.getColour());
    assertEquals(new Point(200, 200), rectangle.getPoint());
    assertEquals(50, rectangle.getWidth(), 0.0001);
    assertEquals(100, rectangle.getHeight(), 0.0001);
  }

  /**
   * Tests the move method.
   */
  @Test
  public void testMove() {
    rectangle.move(300, 300);
    assertEquals(new Point(300, 300), rectangle.getPoint());
  }

  /**
   * Tests the size setter.
   */
  @Test
  public void testResize() {
    rectangle.setWidthAndHeight(75, 150);
    assertEquals(75, rectangle.getWidth(), 0.0001);
    assertEquals(150, rectangle.getHeight(), 0.0001);
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    String expected = "Name: myRectangle\nType: rectangle\nMin corner: (200.0,200.0), Width: 50.0, Height: 100.0, Colour: (255,0,0)";
    assertEquals(expected, rectangle.toString());
  }

  /**
   * Tests the draw method.
   */
  @Test
  public void testDraw() {
    int width = 500;
    int height = 500;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();

    // Fill the image with white
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);

    // Draw the rectangle
    rectangle.draw(g);

    // Check if the pixels within the rectangle area are red
    int redRGB = Color.RED.getRGB();
    for (int x = 200; x < 200 + 50; x++) {
      for (int y = 200; y < 200 + 100; y++) {
        assertEquals(redRGB, image.getRGB(x, y));
      }
    }
  }

  /**
   * Tests the toSVG method.
   */
  @Test
  public void testToSVG() {
    String expected = "<rect x=\"200.0\" y=\"200.0\" " +
            "width=\"50.0\" height=\"100.0\" fill=\"rgb(255,0,0)\" stroke=\"rgb(255,0,0)\" />";
    assertEquals(expected, rectangle.toSVG());
  }
}

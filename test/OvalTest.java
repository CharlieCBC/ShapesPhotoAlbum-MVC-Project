import model.Colour;
import model.Oval;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;

import static org.junit.Assert.assertEquals;

/**
 * A class representing a test for the Oval class.
 */
public class OvalTest {
  private Oval oval;

  /**
   * Sets up the test environment before each test.
   */
  @Before
  public void setUp() {
    oval = new Oval("myOval", new Colour(0, 255, 0), new Point(300, 200), 60, 30);
  }

  /**
   * Tests getXRadius.
   */
  @Test
  public void testGetXRadius() {
    assertEquals(60, oval.getXRadius(), 0.01);
  }

  /**
   * Tests getYRadius.
   */
  @Test
  public void testGetYRadius() {
    assertEquals(30, oval.getYRadius(), 0.01);
  }

  /**
   * Tests setRadii.
   */
  @Test
  public void testSetRadii() {
    oval.setRadii(40, 20);
    assertEquals(40, oval.getXRadius(), 0.01);
    assertEquals(20, oval.getYRadius(), 0.01);
  }

  /**
   * Tests setRadii with invalid parameters.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetRadiiInvalid() {
    oval.setRadii(-40, -20);
  }

  /**
   * Tests toSVG.
   */
  @Test
  public void testToSVG() {
    String expected = "<ellipse cx=\"300.0\" cy=\"200.0\" " +
            "rx=\"60.0\" ry=\"30.0\" fill=\"rgb(0,255,0)\" stroke=\"rgb(0,255,0)\" />";
    assertEquals(expected, oval.toSVG());
  }
}

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import model.Colour;

/**
 * Tests for the Colour class.
 */
public class ColourTest {
  private Colour colour;

  /**
   * Sets up the colour object.
   */
  @Before
  public void setUp() {
    colour = new Colour(255, 128, 64);
  }

  /**
   * Tests the getRed method.
   */
  @Test
  public void testGetRed() {
    assertEquals(255, colour.getRed());
  }

  /**
   * Tests the getGreen method.
   */
  @Test
  public void testGetGreen() {
    assertEquals(128, colour.getGreen());
  }

  /**
   * Tests the getBlue method.
   */
  @Test
  public void testGetBlue() {
    assertEquals(64, colour.getBlue());
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("255,128,64", colour.toString());
  }

  /**
   * Tests the toAWTColor method.
   */
  @Test
  public void testToAWTColor() {
    Color awtColor = colour.toAWTColor();
    assertEquals(255, awtColor.getRed());
    assertEquals(128, awtColor.getGreen());
    assertEquals(64, awtColor.getBlue());
  }

  /**
   * Tests the equals method.
   */
  @Test
  public void testEquals() {
    Colour colour2 = new Colour(255, 128, 64);
    assertTrue(colour.equals(colour2));
  }

  /**
   * Tests the equals method.
   */
  @Test
  public void testNotEquals() {
    Colour colour2 = new Colour(255, 0, 0);
    assertNotEquals(colour, colour2);
  }

  /**
   * Tests the hashCode method.
   */
  @Test
  public void testHashCode() {
    Colour colour2 = new Colour(255, 128, 64);
    assertEquals(colour.hashCode(), colour2.hashCode());
  }
}

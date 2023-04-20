package model;

import java.awt.Color;

/**
 * the colour class that stores rgb values for shapes.
 */
public class Colour {
  private final int red;
  private final int green;
  private final int blue;

  /**
   * the constructor that sets the rgb values.
   * @param red red value.
   * @param green green value.
   * @param blue blue value.
   */
  public Colour(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * the getter for red value.
   * @return red value.
   */
  public int getRed() {
    return red;
  }

  /**
   * the getter for green value.
   * @return green value.
   */
  public int getGreen() {
    return green;
  }

  /**
   * the getter for blue value.
   * @return blue value.
   */
  public int getBlue() {
    return blue;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getRed()).append(",");
    sb.append(getGreen()).append(",");
    sb.append(getBlue());
    return sb.toString();
  }

  /**
   * converts the colour to an AWT color.
   * @return the AWT color.
   */
  public Color toAWTColor() {
    return new Color(red, green, blue);
  }
}

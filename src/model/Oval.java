package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * the concrete class for oval.
 */
public class Oval extends AbstractShape {
  private double xRadius;
  private double yRadius;
  private Colour colour;
  private Point point;

  /**
   * the constructor for an oval.
   * @param name oval's name.
   * @param colour oval's colour.
   * @param point oval's starting point.
   * @param xRadius oval's x radius.
   * @param yRadius oval's y radius.
   * @throws IllegalArgumentException when invalid parameters were entered.
   */
  public Oval(String name, Colour colour, Point point, double xRadius, double yRadius)
          throws IllegalArgumentException {
    super(name, colour, point, xRadius * 2, yRadius * 2);
    this.xRadius = xRadius;
    this.yRadius = yRadius;
    this.colour = colour;
    this.point = point;
  }

  /**
   * the getter for x radius.
   * @return the x radius.
   */
  public double getXRadius() {
    return xRadius;
  }

  /**
   * the getter for y radius.
   * @return the y radius.
   */
  public double getYRadius() {
    return yRadius;
  }

  /**
   * sets the radii and width and height for oval.
   * @param xRadius oval's x radius.
   * @param yRadius oval's y radius.
   * @throws IllegalArgumentException when 0 or negative value entered.
   */
  public void setRadii(double xRadius, double yRadius)
          throws IllegalArgumentException {
    if (xRadius <= 0 || yRadius <= 0) {
      throw new IllegalArgumentException("Radii cannot be 0 or negative.");
    } else {
      this.xRadius = xRadius;
      this.yRadius = yRadius;
      setWidthAndHeight(xRadius * 2, yRadius * 2);
    }
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(colour.toAWTColor());
    g.fillOval((int) point.getX(), (int) point.getY(), (int) xRadius * 2, (int) yRadius * 2);
  }

  @Override
  public String toSVG() {
    Color color = getColour().toAWTColor();
    String rgbColor =
            "rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
    return "<ellipse cx=\"" + getPoint().getX() + "\" cy=\"" + getPoint().getY()
            + "\" rx=\"" + getXRadius() + "\" ry=\"" + getYRadius()
            + "\" fill=\"" + rgbColor + "\" stroke=\"" + rgbColor + "\" />";
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ").append(getName()).append("\nType: oval\nCenter: (");
    sb.append(getPoint().getX()).append(",").append(getPoint().getY());
    sb.append("), X radius: ").append(getXRadius()).append(", Y radius: ");
    sb.append(getYRadius()).append(", Colour: (").append(getColour()).append(")");
    return sb.toString();
  }
}

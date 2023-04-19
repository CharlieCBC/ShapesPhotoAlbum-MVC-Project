package model;


import java.awt.Point;

/**
 * the concrete rectangle class.
 */
public class Rectangle extends AbstractShape {

  /**
   * the constructor for a rectangle.
   * @param name rectangle's name.
   * @param colour rectangle's colour.
   * @param point rectangle's starting point.
   * @param width rectangle's width.
   * @param height rectangle's height.
   * @throws IllegalArgumentException when invalid parameters were entered.
   */
  public Rectangle(String name, Colour colour, Point point, double width, double height)
          throws IllegalArgumentException {
    super(name, colour, point, width, height);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ").append(getName()).append("\nType: rectangle\nMin corner: (");
    sb.append(getPoint().getX()).append(",").append(getPoint().getY());
    sb.append("), Width: ").append(getWidth()).append(", Height: ");
    sb.append(getHeight()).append(", Colour: (").append(getColour()).append(")");
    return sb.toString();
  }
}

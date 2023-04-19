package model;

import java.awt.Point;

/**
 * the abstract class for shapes.
 */
public abstract class AbstractShape implements IShape {
  private final String name;
  private Colour colour;
  private Point point;
  private double width;
  private double height;

  /**
   * the constructor for a shape.
   * @param name shape's name.
   * @param colour shape's colour.
   * @param point shape's starting point.
   * @param width shape's width.
   * @param height shape's height.
   * @throws IllegalArgumentException when invalid parameters were entered.
   */
  public AbstractShape(
          String name, Colour colour, Point point, double width, double height)
        throws IllegalArgumentException {
    boolean invalidName = (name == null || name.equals("") || name.equals("null"));
    boolean invalidDimension = (width <= 0.0 || height <= 0.0);
    if (invalidName || invalidDimension) {
      throw new IllegalArgumentException("Invalid input.");
    } else {
      this.name = name;
      this.colour = colour;
      this.point = point;
      this.width = width;
      this.height = height;
    }
  }

  /**
   * the getter for a shape's name.
   *
   * @return the name.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * sets the shape's colour.
   *
   * @param colour the desired colour or rgb values.
   */
  @Override
  public void setColour(Colour colour) {
    this.colour = colour;
  }

  /**
   * the getter for colour.
   *
   * @return the rgb values of the shape.
   */
  @Override
  public Colour getColour() {
    return colour;
  }

  /**
   * the getter for the shape's position.
   *
   * @return the current point.
   */
  @Override
  public Point getPoint() {
    return point;
  }

  /**
   * sets the shape's width and height.
   *
   * @param width  the shape's width.
   * @param height the shape's height.
   */
  @Override
  public void setWidthAndHeight(double width, double height)
        throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Dimension cannot be 0 or negative.");
    } else {
      this.height = height;
      this.width = width;
    }
  }

  /**
   * the getter for a shape's width.
   *
   * @return the width.
   */
  @Override
  public double getWidth() {
    return width;
  }

  /**
   * the getter for a shape's height.
   *
   * @return the height.
   */
  @Override
  public double getHeight() {
    return height;
  }

  /**
   * move the shape to a desired position.
   *
   * @param x x coordinate.
   * @param y y coordinate.
   */
  @Override
  public void move(double x, double y) {
    point.setLocation(x, y);
  }
}

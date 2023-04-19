package model;

import java.awt.Point;

/**
 * the interface for Shape model.
 */
public interface IShape {

  /**
   * the getter for a shape's name.
   * @return the name.
   */
  String getName();

  /**
   * sets the shape's colour.
   * @param colour the desired colour or rgb values.
   */
  void setColour(Colour colour);

  /**
   * the getter for colour.
   * @return the rgb values of the shape.
   */
  Colour getColour();

  /**
   * the getter for the shape's position.
   * @return the current point.
   */
  Point getPoint();

  /**
   * sets the shape's width and height.
   * @param width the shape's width.
   * @param height the shape's height.
   */
  void setWidthAndHeight(double width, double height);

  /**
   * the getter for a shape's width.
   * @return the width.
   */
  double getWidth();

  /**
   * the getter for a shape's height.
   * @return the height.
   */
  double getHeight();

  /**
   * move the shape to a desired position.
   * @param x x coordinate.
   * @param y y coordinate.
   */
  void move(double x, double y);
}

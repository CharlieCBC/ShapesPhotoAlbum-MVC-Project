package model;

import java.awt.Point;

/**
 * An interface representing a model that manages shapes and snapshots of those shapes.
 */
public interface IModel {

  /**
   * Adds a new shape to the model's list of shapes.
   *
   * @param name   the name of the shape.
   * @param type   the type of the shape, "rectangle" or "oval".
   * @param colour the colour of the shape.
   * @param point  the location of the upper-left corner of the shape.
   * @param width  the width of the shape.
   * @param height the height of the shape.
   * @throws IllegalArgumentException if an invalid shape type is provided.
   */
  void addShape(String name, String type, Colour colour, Point point, double width, double height);

  /**
   * Removes a shape from the model's list of shapes.
   *
   * @param name the name of the shape to remove.
   */
  void removeShape(String name);

  /**
   * Moves a shape to a new location.
   *
   * @param name the name of the shape to move.
   * @param x    the horizontal distance to move the shape.
   * @param y    the vertical distance to move the shape.
   */
  void moveShape(String name, double x, double y);

  /**
   * Resizes a shape to a new width and height.
   *
   * @param name   the name of the shape to resize.
   * @param width  the new width of the shape.
   * @param height the new height of the shape.
   */
  void resizeShape(String name, double width, double height);

  /**
   * Changes the colour of a shape.
   *
   * @param name   the name of the shape to change colour.
   * @param colour the new colour of the shape.
   */
  void changeShapeColor(String name, Colour colour);

  /**
   * Gets information about each of the shapes in the model.
   *
   * @return a string representation of the shapes in the model.
   */
  String getShapesInfo();

  /**
   * Takes a snapshot of the current state of the model, including shapes and their properties.
   *
   * @param description a description of the snapshot.
   */
  void takeSnapshot(String description);

  /**
   * Gets information about a specific snapshot in the model.
   *
   * @param index the index of the snapshot to get information for.
   * @return a string representation of the snapshot.
   */
  String getSnapshotInfo(int index);

  /**
   * Gets an overview of all the snapshots in the model.
   *
   * @return a string representation of all the snapshots in the model.
   */
  String getSnapshotOverview();

  /**
   * edits the description of a snapshot.
   * @param index the index of the snapshot to edit.
   * @param description the new description of the snapshot.
   */
  void editSnapshotDescription(int index, String description);

  /**
   * Removes all shapes from the model.
   */
  void reset();
}
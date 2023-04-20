package model;

import java.awt.Point;
import java.util.List;

/**
 * A class representing a model that manages shapes and snapshots of those shapes.
 */
public class SnapshotAlbumModel implements ISnapshotAlbumModel {
  private ShapeAlbum shapeAlbum;
  private SnapshotAlbum snapshotAlbum;

  /**
   * Constructs a new model with an empty shape album and snapshot album.
   */
  public SnapshotAlbumModel() {
    shapeAlbum = new ShapeAlbum();
    snapshotAlbum = new SnapshotAlbum(shapeAlbum);
  }

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
  @Override
  public void addShape(
          String name, String type, Colour colour, Point point, double width, double height) {
    IShape shape;
    if (type.equalsIgnoreCase("rectangle")) {
      shape = new Rectangle(name, colour, point, width, height);
    } else if (type.equalsIgnoreCase("oval")) {
      shape = new Oval(name, colour, point, width / 2, height / 2);
    } else {
      throw new IllegalArgumentException("Invalid shape type.");
    }
    shapeAlbum.addShape(shape);
  }

  /**
   * Removes a shape from the model's list of shapes.
   *
   * @param name the name of the shape to remove.
   */
  @Override
  public void removeShape(String name) {
    IShape shape = getShape(name);
    shapeAlbum.removeShape(shape);
  }

  /**
   * Moves a shape to a new location.
   *
   * @param name the name of the shape to move.
   * @param x    the horizontal distance to move the shape.
   * @param y    the vertical distance to move the shape.
   */
  @Override
  public void moveShape(String name, double x, double y) {
    IShape shape = getShape(name);
    shape.move(x, y);
  }

  /**
   * Resizes a shape to a new width and height.
   *
   * @param name   the name of the shape to resize.
   * @param width  the new width of the shape.
   * @param height the new height of the shape.
   */
  @Override
  public void resizeShape(String name, double width, double height) {
    IShape shape = getShape(name);
    shape.setWidthAndHeight(width, height);
  }

  /**
   * Changes the colour of a shape.
   *
   * @param name   the name of the shape to change colour.
   * @param colour the new colour of the shape.
   */
  @Override
  public void changeShapeColor(String name, Colour colour) {
    IShape shape = getShape(name);
    shape.setColour(colour);
  }

  /**
   * Gets information about each of the shapes in the model.
   *
   * @return a string representation of the shapes in the model.
   */
  @Override
  public String getShapesInfo() {
    return shapeAlbum.toString();
  }

  /**
   * Takes a snapshot of the current state of the model, including shapes and their properties.
   *
   * @param description a description of the snapshot.
   */
  @Override
  public void takeSnapshot(String description) {
    snapshotAlbum.takeSnapshot(description);
  }

  /**
   * Gets information about a specific snapshot in the model.
   *
   * @param index the index of the snapshot to get information for.
   * @return a string representation of the snapshot.
   */
  @Override
  public String getSnapshotInfo(int index) {
    return snapshotAlbum.getSnapshots().get(index).toString();
  }

  /**
   * Gets an overview of all the snapshots in the model.
   *
   * @return a string representation of all the snapshots in the model.
   */
  @Override
  public String getSnapshotOverview() {
    return snapshotAlbum.toString();
  }

  /**
   * edits the description of a snapshot.
   *
   * @param index       the index of the snapshot to edit.
   * @param description the new description of the snapshot.
   */
  @Override
  public void editSnapshotDescription(int index, String description) {
    snapshotAlbum.getSnapshots().get(index).editDescription(description);
  }

  /**
   * Gets the snapshot album.
   *
   * @return the snapshot album.
   */
  @Override
  public SnapshotAlbum getSnapshotAlbum() {
    return snapshotAlbum;
  }

  /**
   * gets the snapshot at the given index.
   *
   * @param index the index of the snapshot to get.
   * @return the snapshot at the given index.
   */
  @Override
  public Snapshot getSnapshot(int index) {
    return snapshotAlbum.getSnapshots().get(index);
  }

  /**
   * Removes all shapes from the model.
   */
  @Override
  public void reset() {
    shapeAlbum.reset();
  }

  /**
   * Helper method to find a shape in the shape album by name.
   *
   * @param name the name of the shape to find.
   * @return the shape with the given name, or null if no such shape exists.
   */
  private IShape getShape(String name) {
    List<IShape> shapes = shapeAlbum.getShapes();
    for (IShape shape : shapes) {
      if (shape.getName().equals(name)) {
        return shape;
      }
    }
    return null;
  }
}
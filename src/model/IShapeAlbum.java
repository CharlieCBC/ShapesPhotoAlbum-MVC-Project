package model;

import java.util.List;

/**
 * the interface for shapeAlbum.
 */
public interface IShapeAlbum {
  /**
   * add a shape to the album.
   * @param shape the shape to add.
   */
  void addShape(IShape shape);

  /**
   * remove a shape from album.
   * @param shape the shape to remove.
   */
  void removeShape(IShape shape);

  /**
   * get all shapes.
   * @return the arraylist containing shapes.
   */
  List<IShape> getShapes();

  /**
   * resets by emptying the arraylist.
   */
  void reset();
}

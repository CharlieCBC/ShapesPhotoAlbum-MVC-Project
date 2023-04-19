package model;

import java.util.ArrayList;
import java.util.List;

/**
 * shapeAlbum puts multiple shapes in an array list.
 */
public class ShapeAlbum {
  private final List<IShape> shapes;

  /**
   * the constructor that initializes an arraylist.
   */
  public ShapeAlbum() {
    shapes = new ArrayList<>();
  }

  /**
   * add a shape to the album.
   * @param shape the shape to add.
   */
  public void addShape(IShape shape) {
    shapes.add(shape);
  }

  /**
   * remove a shape from album.
   * @param shape the shape to remove.
   */
  public void removeShape(IShape shape) {
    shapes.remove(shape);
  }

  /**
   * get all shapes.
   * @return the arraylist containing shapes.
   */
  public List<IShape> getShapes() {
    return shapes;
  }

  /**
   * resets by emptying the arraylist.
   */
  public void reset() {
    shapes.clear();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < getShapes().size(); i++) {
      sb.append(getShapes().get(i).toString()).append("\n");
    }
    return sb.toString();
  }
}

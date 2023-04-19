package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * snapshot class stores shapes' snapshot info.
 */
public class Snapshot {
  private String description;
  private final List<IShape> shapes;
  private final LocalDateTime timeStamp;

  public Snapshot(String description, ShapeAlbum album, LocalDateTime timeStamp)
          throws IllegalArgumentException {
    boolean invalidDescription = (description == null || description.equals("null"));
    if (invalidDescription) {
      throw new IllegalArgumentException("Invalid description.");
    }
    this.description = description;
    this.shapes = new ArrayList<>(album.getShapes());
    this.timeStamp = timeStamp;
  }

  /**
   * edits the description.
   * @param description the desired description.
   */
  public void editDescription(String description) {
    this.description = description;
  }

  /**
   * the getter for the time stamp.
   * @return the snapshot's time stamp.
   */
  public LocalDateTime getTimeStamp() {
    return timeStamp;
  }

  /**
   * the getter for the snapshot's description.
   * @return the description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * the getter for the shapes.
   * @return the shapes.
   */
  public List<IShape> getShapes() {
    return shapes;
  }

  /**
   * the getter for a formatted time stamp.
   * @return the formatted time stamp.
   */
  public String getFormattedTimestamp() {
    return timeStamp.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Snapshot ID: ").append(getTimeStamp()).append("\n");
    sb.append("Timestamp: ").append(getFormattedTimestamp()).append("\n");
    sb.append("Description: ").append(getDescription()).append("\n");
    sb.append("Shape Information:\n");
    for (int i = 0; i < getShapes().size(); i++) {
      IShape shape = getShapes().get(i);
      sb.append(shape).append("\n");
    }
    return sb.toString();
  }
}

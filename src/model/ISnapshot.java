package model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * the interface for snapshot.
 */
public interface ISnapshot {
  /**
   * edits the description.
   * @param description the desired description.
   */
  void editDescription(String description);

  /**
   * the getter for the time stamp.
   * @return the snapshot's time stamp.
   */
  LocalDateTime getTimeStamp();

  /**
   * the getter for the snapshot's description.
   * @return the description.
   */
  String getDescription();

  /**
   * the getter for the shapes.
   * @return the shapes.
   */
  List<IShape> getShapes();

  /**
   * the getter for the formatted time stamp.
   * @return the formatted time stamp.
   */
  String getFormattedTimestamp();
}

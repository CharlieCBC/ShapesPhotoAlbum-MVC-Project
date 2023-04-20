package model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * the interface for the snapshot album.
 */
public interface ISnapshotAlbum {
  /**
   * takes a snapshot of the shape album.
   * @param description the desired snapshot description.
   */
  void takeSnapshot(String description);

  /**
   * the getter for the snapshots.
   * @return the arraylist that contains snapshots.
   */
  List<Snapshot> getSnapshots();

  /**
   * sets the snapshots overview.
   */
  void setOverview();

  /**
   * the getter for the snapshots overview.
   * @return the arraylist that contains snapshots overview.
   */
  List<LocalDateTime> getOverview();
}

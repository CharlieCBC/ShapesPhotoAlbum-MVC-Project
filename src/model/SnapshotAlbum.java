package model;

import java.awt.Point;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * the SnapshotAlbum takes snapshots and puts multiple snapshots together.
 */
public class SnapshotAlbum {
  private final ShapeAlbum shapeAlbum;
  private final List<Snapshot> snapshots;
  private final List<LocalDateTime> snapshotIds;

  /**
   * the constructor that initializes a shapesAlbum,
   * a snapshots arraylist, and a snapshot Id arraylist.
   * @param shapeAlbum the shape Album to take snapshot with.
   */
  public SnapshotAlbum(ShapeAlbum shapeAlbum) {
    this.shapeAlbum = shapeAlbum;
    this.snapshots = new ArrayList<>();
    this.snapshotIds = new ArrayList<>();
  }

  /**
   * takes a snapshot of the shape album.
   * @param description the desired snapshot description.
   */
  public void takeSnapshot(String description) {
    ShapeAlbum snapshotAlbum = new ShapeAlbum(); // create new instance of shape album for snapshot
    for (IShape shape : shapeAlbum.getShapes()) {
      IShape snapshotShape;
      if (shape instanceof Rectangle) {
        Rectangle rectangle = (Rectangle) shape;
        snapshotShape = new Rectangle(rectangle.getName(), rectangle.getColour(),
                new Point(rectangle.getPoint()), rectangle.getWidth(), rectangle.getHeight());
      } else {
        Oval oval = (Oval) shape;
        snapshotShape = new Oval(oval.getName(), oval.getColour(),
                new Point(oval.getPoint()), oval.getWidth(), oval.getHeight());
      }
      snapshotAlbum.addShape(snapshotShape); // add new shape instance to snapshot album
    }
    Snapshot snapshot = new Snapshot(description, snapshotAlbum, LocalDateTime.now());
    snapshots.add(snapshot);
  }

  /**
   * the getter for the snapshots.
   * @return the arraylist that contains snapshots.
   */
  public List<Snapshot> getSnapshots() {
    return snapshots;
  }

  /**
   * sets the snapshots overview.
   */
  public void setOverview() {
    for (int i = 0; i < snapshots.size(); i++) {
      snapshotIds.add(snapshots.get(i).getTimeStamp());
    }
  }

  /**
   * the getter for the snapshots' overview.
   * @return the overview.
   */
  public List<LocalDateTime> getOverview() {
    return snapshotIds;
  }

  @Override
  public String toString() {
    setOverview();
    StringBuilder sb = new StringBuilder();
    sb.append("List of snapshots taken before reset: ").append(getOverview());

    sb.append("\n\nPrinting snapshots:\n");
    for (Snapshot snapshot : getSnapshots()) {
      sb.append(snapshot.toString());
      sb.append("\n");
    }
    return sb.toString();
  }
}

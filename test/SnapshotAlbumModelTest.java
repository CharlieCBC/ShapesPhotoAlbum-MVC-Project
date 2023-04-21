import model.Colour;
import model.Snapshot;
import model.SnapshotAlbumModel;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The class that tests the SnapshotAlbumModel class.
 */
public class SnapshotAlbumModelTest {
  private SnapshotAlbumModel model;

  /**
   * Sets up the model for testing.
   */
  @Before
  public void setUp() {
    model = new SnapshotAlbumModel();
  }

  /**
   * Tests the addShape method.
   */
  @Test
  public void testAddShape() {
    model.addShape("Rectangle1", "rectangle", new Colour(0, 0, 255), new Point(50, 50), 100, 50);
    model.takeSnapshot("11");
    assertEquals(1, model.getSnapshotAlbum().getSnapshots().size());
  }

  /**
   * Tests the removeShape method.
   */
  @Test
  public void testRemoveShape() {
    model.addShape("Rectangle1", "rectangle", new Colour(0, 0, 255), new Point(50, 50), 100, 50);
    model.removeShape("Rectangle1");
    assertEquals(0, model.getSnapshotAlbum().getSnapshots().size());
  }

  /**
   * Tests takeSnapshot method.
   */
  @Test
  public void testTakeSnapshot() {
    model.addShape("Rectangle1", "rectangle", new Colour(0, 0, 255), new Point(50, 50), 100, 50);
    model.takeSnapshot("Snapshot 1");
    assertEquals(1, model.getSnapshotAlbum().getSnapshots().size());
  }

  /**
   * Tests the editSnapshotDescription method.
   */
  @Test
  public void testEditSnapshotDescription() {
    model.addShape("Rectangle1", "rectangle", new Colour(0, 0, 255), new Point(50, 50), 100, 50);
    model.takeSnapshot("Snapshot 1");
    model.editSnapshotDescription(0, "New description");
    assertEquals("New description", model.getSnapshot(0).getDescription());
  }

  /**
   * Tests the getShapesInfo method.
   */
  @Test
  public void testGetShapesInfo() {
    model.addShape("Rectangle1", "rectangle", new Colour(0, 0, 255), new Point(50, 50), 100, 50);
    String shapesInfo = model.getShapesInfo();
    assertNotNull(shapesInfo);
  }

  /**
   * Tests the getShapesOverview method.
   */
  @Test
  public void testGetSnapshotInfo() {
    model.addShape("Rectangle1", "rectangle", new Colour(0, 0, 255), new Point(50, 50), 100, 50);
    model.takeSnapshot("Snapshot 1");
    String snapshotInfo = model.getSnapshotInfo(0);
    assertNotNull(snapshotInfo);
  }

  /**
   * Tests the getSnapshotOverview method.
   */
  @Test
  public void testGetSnapshotOverview() {
    model.addShape("Rectangle1", "rectangle", new Colour(0, 0, 255), new Point(50, 50), 100, 50);
    model.takeSnapshot("Snapshot 1");
    model.takeSnapshot("Snapshot 2");
    String snapshotOverview = model.getSnapshotOverview();
    assertNotNull(snapshotOverview);
  }

  /**
   * Tests the getSnapshot method.
   */
  @Test
  public void testGetSnapshot() {
    model.addShape("Rectangle1", "rectangle", new Colour(0, 0, 255), new Point(50, 50), 100, 50);
    model.takeSnapshot("Snapshot 1");
    Snapshot snapshot = model.getSnapshot(0);
    assertNotNull(snapshot);
  }
}

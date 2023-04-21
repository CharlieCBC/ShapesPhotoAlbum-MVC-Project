import org.junit.Before;
import org.junit.Test;

import java.awt.Point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import model.Colour;
import model.Oval;
import model.Rectangle;
import model.ShapeAlbum;
import model.SnapshotAlbum;

/**
 * The test class for SnapshotAlbum.
 */
public class SnapshotAlbumTest {
  private ShapeAlbum shapeAlbum;
  private Oval oval;
  private Rectangle rectangle;
  private SnapshotAlbum snapshotAlbum;

  /**
   * Sets up the test.
   */
  @Before
  public void setUp() {
    shapeAlbum = new ShapeAlbum();
    oval = new Oval("Oval1", new Colour(255, 0, 0), new Point(10, 10), 20, 10);
    rectangle = new Rectangle("Rectangle1", new Colour(0, 255, 0), new Point(20, 20), 30, 40);
    shapeAlbum.addShape(oval);
    shapeAlbum.addShape(rectangle);
    snapshotAlbum = new SnapshotAlbum(shapeAlbum);
  }

  /**
   * Tests the takeSnapshot method.
   */
  @Test
  public void testTakeSnapshot() {
    snapshotAlbum.takeSnapshot("Snapshot 1");
    assertEquals(1, snapshotAlbum.getSnapshots().size());
  }

  /**
   * Tests the getSnapshots method.
   */
  @Test
  public void testGetSnapshots() {
    snapshotAlbum.takeSnapshot("Snapshot 1");
    snapshotAlbum.takeSnapshot("Snapshot 2");
    assertEquals(2, snapshotAlbum.getSnapshots().size());
  }

  /**
   * Tests the setOverview method.
   */
  @Test
  public void testSetOverview() {
    snapshotAlbum.takeSnapshot("Snapshot 1");
    snapshotAlbum.takeSnapshot("Snapshot 2");
    snapshotAlbum.setOverview();
    assertEquals(2, snapshotAlbum.getOverview().size());
  }

  /**
   * Tests the getOverview method.
   */
  @Test
  public void testGetOverview() {
    snapshotAlbum.takeSnapshot("Snapshot 1");
    snapshotAlbum.takeSnapshot("Snapshot 2");
    snapshotAlbum.setOverview();
    assertNotNull(snapshotAlbum.getOverview());
  }
}

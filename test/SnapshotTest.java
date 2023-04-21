import org.junit.Before;
import org.junit.Test;

import java.awt.Point;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import model.Colour;
import model.Oval;
import model.Rectangle;
import model.ShapeAlbum;
import model.Snapshot;

/**
 * Test class for Snapshot.
 */
public class SnapshotTest {
  private ShapeAlbum shapeAlbum;
  private Oval oval;
  private Rectangle rectangle;
  private Snapshot snapshot;

  /**
   * Sets up the test fixture.
   */
  @Before
  public void setUp() {
    shapeAlbum = new ShapeAlbum();
    oval = new Oval("Oval1", new Colour(255, 0, 0), new Point(10, 10), 20, 10);
    rectangle = new Rectangle("Rectangle1", new Colour(0, 255, 0), new Point(20, 20), 30, 40);
    shapeAlbum.addShape(oval);
    shapeAlbum.addShape(rectangle);
    snapshot = new Snapshot("Initial State", shapeAlbum, LocalDateTime.now());
  }

  /**
   * Tests the constructor for Snapshot.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDescription() {
    new Snapshot(null, shapeAlbum, LocalDateTime.now());
  }

  /**
   * Tests the editDescription method.
   */
  @Test
  public void testEditDescription() {
    String newDescription = "Updated description";
    snapshot.editDescription(newDescription);
    assertEquals(newDescription, snapshot.getDescription());
  }

  /**
   * Tests the getTimeStamp method.
   */
  @Test
  public void testGetTimeStamp() {
    assertNotNull(snapshot.getTimeStamp());
  }

  /**
   * Tests the getDescription method.
   */
  @Test
  public void testGetDescription() {
    assertEquals("Initial State", snapshot.getDescription());
  }

  /**
   * Tests the getShapes method.
   */
  @Test
  public void testGetShapes() {
    assertEquals(2, snapshot.getShapes().size());
    assertTrue(snapshot.getShapes().contains(oval));
    assertTrue(snapshot.getShapes().contains(rectangle));
  }

  /**
   * Tests the getFormattedTimestamp method.
   */
  @Test
  public void testGetFormattedTimestamp() {
    assertNotNull(snapshot.getFormattedTimestamp());
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    String expected = "Snapshot ID: " + snapshot.getTimeStamp() + "\n"
            + "Timestamp: " + snapshot.getFormattedTimestamp() + "\n"
            + "Description: " + snapshot.getDescription() + "\n"
            + "Shape Information:\n"
            + oval + "\n"
            + rectangle + "\n";
    assertEquals(expected, snapshot.toString());
  }
}

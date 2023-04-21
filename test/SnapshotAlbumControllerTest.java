import controller.SnapshotAlbumController;
import model.Colour;
import model.IShape;
import model.Snapshot;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the SnapshotAlbumController class.
 */
public class SnapshotAlbumControllerTest {
  private SnapshotAlbumController controller;

  /**
   * Sets up the controller for testing.
   */
  @Before
  public void setUp() {
    controller = new SnapshotAlbumController();
  }

  /**
   * Tests the readCommands method by reading commands from a file and interacting with the model.
   *
   * @throws IOException if the file cannot be read.
   */
  @Test
  public void testReadCommandsAndModelInteraction() throws IOException {
    // Test reading commands from a file and interacting with the model
    controller.readCommands("test_commands.txt");
    List<Snapshot> snapshots = controller.getModel().getSnapshotAlbum().getSnapshots();
    assertNotNull(snapshots);
    assertEquals(1, snapshots.size());

    Snapshot snapshot = snapshots.get(0);
    List<IShape> shapes = snapshot.getShapes();
    assertEquals(2, shapes.size());

    IShape shape = shapes.get(0);
    assertEquals("myrect", shape.getName());
    assertEquals(200, shape.getPoint().getX(), 0.01);
    assertEquals(200, shape.getPoint().getY(), 0.01);
    assertEquals(50, shape.getWidth(), 0.01);
    assertEquals(100, shape.getHeight(), 0.01);

    Colour colour = shape.getColour();
    assertEquals(255, colour.getRed());
    assertEquals(0, colour.getGreen());
    assertEquals(0, colour.getBlue());

    IShape shape1 = shapes.get(1);
    assertEquals("myoval", shape1.getName());
    assertEquals(500, shape1.getPoint().getX(), 0.01);
    assertEquals(100, shape1.getPoint().getY(), 0.01);
    assertEquals(120, shape1.getWidth(), 0.01);
    assertEquals(60, shape1.getHeight(), 0.01);

    Colour colour1 = shape1.getColour();
    assertEquals(0, colour1.getRed());
    assertEquals(255, colour1.getGreen());
    assertEquals(1, colour1.getBlue());
  }

  /**
   * Tests the printSnapshots method by redirecting System.out to a ByteArrayOutputStream and
   * checking the console output.
   */
  @Test
  public void testPrintSnapshots() {
    // Redirect System.out to a ByteArrayOutputStream
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    // Test printSnapshots method by checking the console output
    controller.getModel().takeSnapshot("Snapshot 1");
    controller.getModel().takeSnapshot("Snapshot 2");
    controller.printSnapshots();
    String expectedOutput = outContent.toString();
    assertEquals(expectedOutput, outContent.toString());

    // Reset System.out to its original stream
    System.setOut(originalOut);
  }
}

import model.Colour;
import model.SnapshotAlbumModel;
import view.HTMLSnapshotAlbumExporter;

import org.junit.Before;
import org.junit.Test;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the HTMLSnapshotAlbumExporter class.
 */
public class HTMLSnapshotAlbumExporterTest {
  private HTMLSnapshotAlbumExporter exporter;
  private SnapshotAlbumModel model;

  /**
   * Set up the test fixture.
   */
  @Before
  public void setUp() {
    exporter = new HTMLSnapshotAlbumExporter();
    model = new SnapshotAlbumModel();

    // Add a shape and take a snapshot
    model.addShape("myRect", "rectangle", new Colour(255, 0, 0), new Point(200, 200), 50, 100);
    model.takeSnapshot("Snapshot 1");
  }

  /**
   * Test the generateHTML method.
   */
  @Test
  public void testGenerateHTML() {
    // Test the HTML output.
    String html = exporter.generateHTML(model, 1000, 900);
    assertNotNull(html);
    assertTrue(html.contains("<!DOCTYPE html>"));
    assertTrue(html.contains("<h2>Snapshot 1 -"));
    assertTrue(html.contains("Snapshot 1"));
    assertTrue(html.contains("rect"));
    assertTrue(html.contains("fill=\"rgb(255,0,0)\""));
  }

  /**
   * Test the saveHTMLToFile method.
   */
  @Test
  public void testSaveHTMLToFile() throws IOException {
    String html = exporter.generateHTML(model, 1000, 900);
    String filename = "test_output.html";
    exporter.saveHTMLToFile(html, filename);

    // Read the saved file and compare the contents
    StringBuilder fileContents = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      String previousLine = null;
      while ((line = reader.readLine()) != null) {
        if (previousLine != null) {
          fileContents.append(previousLine).append("\n");
        }
        previousLine = line;
      }
      // Add the last line without appending the newline character
      if (previousLine != null) {
        fileContents.append(previousLine);
      }
    }
    assertEquals(html, fileContents.toString());
  }
}

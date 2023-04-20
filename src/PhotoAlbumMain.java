import java.io.FileWriter;
import java.io.IOException;

import controller.SnapshotAlbumController;
import view.HTMLSnapshotAlbumExporter;
import view.SnapshotAlbumView;

public class PhotoAlbumMain {
  public static void main(String[] args) {
    SnapshotAlbumController controller = new SnapshotAlbumController();

    try {
       controller.readCommands("hoops.txt");
//      controller.readCommands("buildings.txt");
      // controller.readCommands("demo_input.txt");
    } catch (IOException e) {
      System.err.println("Error reading commands file: " + e.getMessage());
    }

    controller.printSnapshots();

    // Create and display the snapshot album view
    SnapshotAlbumView view = new SnapshotAlbumView(controller.getModel());

    // Generate HTML+SVG content and save it to a file
    HTMLSnapshotAlbumExporter exporter = new HTMLSnapshotAlbumExporter();
    String htmlContent = exporter.generateHTML(controller.getModel());
    try (FileWriter fileWriter = new FileWriter("output.html")) {
      fileWriter.write(htmlContent);
    } catch (IOException e) {
      System.err.println("Error writing HTML+SVG file: " + e.getMessage());
    }
  }
}

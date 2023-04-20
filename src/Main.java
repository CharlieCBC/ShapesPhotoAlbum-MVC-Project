import java.io.IOException;

import controller.SnapshotAlbumController;
import model.Model;
import view.HTMLSnapshotAlbumExporter;
import view.SnapshotAlbumView;

public class Main {
  public static void main(String[] args) {
    SnapshotAlbumController reader = new SnapshotAlbumController();
    try {
      reader.readCommands("demo_input.txt");
      reader.printSnapshots();
    } catch (IOException e) {
      System.err.println("Error reading command file: " + e.getMessage());
    }


//    Model model = new Model();
//    Controller controller = new Controller(model);
//
//    // Replace "filename.txt" with the path to your file containing the commands.
//    controller.processCommandsFromFile("demo_input.txt");
//
//    System.out.println(model.getShapesInfo());
//    System.out.println(model.getSnapshotOverview());


//    Model model = new Model();
//    // Add some sample data to the model
//
//    // Generate HTML content and save it to a file
//    HTMLSnapshotAlbumExporter exporter = new HTMLSnapshotAlbumExporter();
//    String htmlContent = exporter.generateHTML(model);
//    exporter.saveHTMLToFile(htmlContent, "snapshot_album.html");
//
//    new SnapshotAlbumView(model);
  }
}

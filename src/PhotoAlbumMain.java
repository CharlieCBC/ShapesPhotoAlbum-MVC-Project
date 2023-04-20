import controller.SnapshotAlbumController;
import java.io.IOException;
import view.HTMLSnapshotAlbumExporter;
import view.SnapshotAlbumView;

/**
 * The main class for the Photo Album application.
 */
public class PhotoAlbumMain {
  /**
   * The main method for the Photo Album application.
   *
   * @param args the command line arguments.
   */
  public static void main(String[] args) {
    String inputFile = null;
    String view = null;
    String outputFile = null;
    // Default dimensions for the web view.
    int width = 1000;
    int height = 1000;

    // Parse the command line arguments.
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "-in":
          inputFile = args[++i];
          break;
        case "-view":
        case "-v":
          view = args[++i];
          break;
        case "-out":
          outputFile = args[++i];
          break;
        default:
          if (width == 1000) {
            width = Integer.parseInt(args[i]);
          } else {
            height = Integer.parseInt(args[i]);
          }
          break;
      }
    }

    // Check for required arguments.
    if (inputFile == null || view == null) {
      System.err.println("Missing required arguments.");
      return;
    }

    // Create the controller and read the commands file.
    SnapshotAlbumController controller = new SnapshotAlbumController();

    try {
      controller.readCommands(inputFile);
    } catch (IOException e) {
      System.err.println("Error reading commands file: " + e.getMessage());
      return;
    }

    // Create the view.
    if (view.equalsIgnoreCase("graphical")) {
      SnapshotAlbumView swingView = new SnapshotAlbumView(controller.getModel());
    } else if (view.equalsIgnoreCase("web")) {
      if (outputFile == null) {
        System.err.println("Missing required output file for web view.");
        return;
      }
      HTMLSnapshotAlbumExporter exporter = new HTMLSnapshotAlbumExporter();
      String htmlOutput = exporter.generateHTML(controller.getModel(), width, height);

      exporter.saveHTMLToFile(htmlOutput, outputFile);
    } else {
      System.err.println("Invalid view type.");
    }
  }
}

import java.io.IOException;

import controller.SnapshotAlbumController;

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
  }
}

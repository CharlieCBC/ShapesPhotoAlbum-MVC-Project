package view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Snapshot;
import model.IShape;
import model.Model;

public class HTMLSnapshotAlbumExporter {
  public String generateHTML(Model model) {
    StringBuilder sb = new StringBuilder();
    sb.append("<!DOCTYPE html>\n<html>\n<head>\n<title>Snapshot Album</title>\n</head>\n<body>\n");

    List<Snapshot> snapshots = model.getSnapshotAlbum().getSnapshots();

    // Define the dimensions of the drawing area
    int width = 1000;
    int height = 900;

    for (int i = 0; i < snapshots.size(); i++) {
      Snapshot snapshot = snapshots.get(i);
      sb.append("<div>\n<h2>Snapshot ")
              .append(i + 1)
              .append(" - ")
              .append(snapshot.getTimeStamp())
              .append(" - ")
              .append(snapshot.getDescription())
              .append("</h2>\n");

      // Set the SVG viewbox to match the drawing area dimensions
      sb.append("<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 ")
              .append(width)
              .append(" ")
              .append(height)
              .append("\">\n");

      for (IShape shape : snapshot.getShapes()) {
        sb.append(shape.toSVG());
      }
      sb.append("</svg>\n</div>\n");
    }
    sb.append("</body>\n</html>");

    return sb.toString();
  }

  public void saveHTMLToFile(String html, String filename) {
    try (FileWriter fileWriter = new FileWriter(filename)) {
      fileWriter.write(html);
    } catch (IOException e) {
      System.err.println("Error writing the file: " + e.getMessage());
    }
  }
}


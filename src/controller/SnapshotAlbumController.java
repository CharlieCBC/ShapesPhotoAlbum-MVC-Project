package controller;

import model.Model;
import model.Colour;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SnapshotAlbumController {
  private Model model;

  public SnapshotAlbumController() {
    model = new Model();
  }

  public void readCommands(String filename) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] tokens = line.trim().split("\\s+");
        if (tokens[0].equalsIgnoreCase("shape")) {
          String name = tokens[1];
          String type = tokens[2];
          double x = Double.parseDouble(tokens[3]);
          double y = Double.parseDouble(tokens[4]);
          double width = Double.parseDouble(tokens[5]);
          double height = Double.parseDouble(tokens[6]);
          float red = Float.parseFloat(tokens[7]);
          float green = Float.parseFloat(tokens[8]);
          float blue = Float.parseFloat(tokens[9]);
          Point point = new Point((int) x, (int) y);
          Colour colour = new Colour(red, green, blue);
          model.addShape(name, type, colour, point, width, height);
        } else if (tokens[0].equalsIgnoreCase("snapshot")) {
          String description = "";
          if (tokens.length > 1) {
            for (int i = 1; i < tokens.length; i++) {
              description += tokens[i] + " ";
            }
            description = description.trim();
          }
          model.takeSnapshot(description);
        } else if (tokens[0].equalsIgnoreCase("move")) {
          String name = tokens[1];
          double x = Double.parseDouble(tokens[2]);
          double y = Double.parseDouble(tokens[3]);
          model.moveShape(name, x, y);
        } else if (tokens[0].equalsIgnoreCase("resize")) {
          String name = tokens[1];
          double width = Double.parseDouble(tokens[2]);
          double height = Double.parseDouble(tokens[3]);
          model.resizeShape(name, width, height);
        } else if (tokens[0].equalsIgnoreCase("color")) {
          String name = tokens[1];
          float red = Float.parseFloat(tokens[2]);
          float green = Float.parseFloat(tokens[3]);
          float blue = Float.parseFloat(tokens[4]);
          Colour colour = new Colour(red, green, blue);
          model.changeShapeColor(name, colour);
        } else if (tokens[0].equalsIgnoreCase("remove")) {
          String name = tokens[1];
          model.removeShape(name);
        }
      }
    }
  }

  public void printSnapshots() {
    System.out.println(model.getSnapshotOverview());
  }
}
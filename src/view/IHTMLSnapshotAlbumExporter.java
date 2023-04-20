package view;

import model.SnapshotAlbumModel;

/**
 * The interface for the HTML snapshot album exporter.
 */
public interface IHTMLSnapshotAlbumExporter {
  /**
   * Generates an HTML file containing a snapshot album.
   *
   * @param model the model containing the snapshot album.
   * @param width the width of the drawing area.
   * @param height the height of the drawing area.
   * @return the HTML file as a string.
   */
  String generateHTML(SnapshotAlbumModel model, int width, int height);

  /**
   * Saves the given HTML string to the given file.
   *
   * @param html the HTML string to save.
   * @param filename the name of the file to save to.
   */
  void saveHTMLToFile(String html, String filename);
}
package controller;

import java.io.IOException;

/**
 * The interface for the snapshot album controller.
 */
public interface ISnapshotAlbumController {
  /**
   * Reads commands from a file.
   *
   * @param filename the name of the file.
   * @throws IOException when the file is not found.
   */
  void readCommands(String filename) throws IOException;

  /**
   * Prints the snapshots.
   */
  void printSnapshots();
}
package view;

/**
 * The interface for the snapshot album view.
 */
public interface ISnapshotAlbumView {
  /**
   * Displays the snapshot at the given index.
   *
   * @param index the index of the snapshot to display.
   */
  void displaySnapshot(int index);

  /**
   * Displays the previous snapshot.
   */
  void previousSnapshot();

  /**
   * Displays the next snapshot.
   */
  void nextSnapshot();

  /**
   * Displays the snapshot at the given index.
   *
   * @param index the index of the snapshot to display.
   */
  void jumpToSnapshot(int index);
}

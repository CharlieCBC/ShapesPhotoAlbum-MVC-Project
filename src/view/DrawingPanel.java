package view;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.IShape;
import model.Snapshot;

/**
 * A panel that displays a snapshot.
 * A helper class for SnapshotAlbumView.
 */
public class DrawingPanel extends JPanel {
  private Snapshot snapshot;

  /**
   * Constructs a DrawingPanel.
   */
  DrawingPanel() {
    setPreferredSize(new Dimension(400, 300));
  }

  /**
   * Sets the snapshot to display.
   *
   * @param snapshot the snapshot to display.
   */
  public void setSnapshot(Snapshot snapshot) {
    this.snapshot = snapshot;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (snapshot != null) {
      for (IShape shape : snapshot.getShapes()) {
        shape.draw(g);
      }
    }
  }
}

package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Model;
import model.Snapshot;

/**
 * A view that displays a snapshot album.
 */
public class SnapshotAlbumView extends JFrame implements ISnapshotAlbumView {
  private final Model model;
  private final DrawingPanel drawingPanel;
  private int currentIndex;
  private final JLabel snapshotTimestampAndDescription;

  /**
   * Constructs a SnapshotAlbumView.
   *
   * @param model the model
   */
  public SnapshotAlbumView(Model model) {
    this.model = model;
    this.currentIndex = -1;
    setTitle("Snapshot Album Viewer");
    setSize(1000, 900);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel(new BorderLayout());
    drawingPanel = new DrawingPanel();
    panel.add(drawingPanel, BorderLayout.CENTER);
    JPanel controlPanel = new JPanel();

    JButton previousButton = new JButton("Previous");
    previousButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        previousSnapshot();
      }
    });
    controlPanel.add(previousButton);
    JButton nextButton = new JButton("Next");
    nextButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        nextSnapshot();
      }
    });
    controlPanel.add(nextButton);
    JComboBox<String> jumpToCombo = new JComboBox<>();
    List<Snapshot> snapshots = model.getSnapshotAlbum().getSnapshots();
    for (int i = 0; i < snapshots.size(); i++) {
      jumpToCombo.addItem("Snapshot " + (i + 1) + " " + snapshots.get(i).getTimeStamp().toString());
    }
    jumpToCombo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int selectedIndex = jumpToCombo.getSelectedIndex();
        jumpToSnapshot(selectedIndex);
      }
    });
    controlPanel.add(jumpToCombo);
    panel.add(controlPanel, BorderLayout.SOUTH);
    snapshotTimestampAndDescription = new JLabel();
    panel.add(snapshotTimestampAndDescription, BorderLayout.NORTH);

    add(panel);
    displaySnapshot(0);
    setVisible(true);
  }

  /**
   * Displays the snapshot at the given index.
   *
   * @param index the index of the snapshot to display.
   */
  public void displaySnapshot(int index) {
    if (index >= 0 && index < model.getSnapshotAlbum().getSnapshots().size()) {
      currentIndex = index;
      Snapshot snapshot = model.getSnapshotAlbum().getSnapshots().get(index);
      drawingPanel.setSnapshot(snapshot);

      // Update the timestamp and description JLabel
      snapshotTimestampAndDescription
              .setText(snapshot.getTimeStamp() + ": " + snapshot.getDescription());

      repaint();
    }
  }

  /**
   * Displays the previous snapshot.
   */
  public void previousSnapshot() {
    if (currentIndex > 0) {
      displaySnapshot(currentIndex - 1);
    } else {
      JOptionPane.showMessageDialog(this, "No previous snapshot.");
    }
  }

  /**
   * Displays the next snapshot.
   */
  public void nextSnapshot() {
    if (currentIndex < model.getSnapshotAlbum().getSnapshots().size() - 1) {
      displaySnapshot(currentIndex + 1);
    } else {
      JOptionPane.showMessageDialog(this, "No further snapshots.");
    }
  }

  /**
   * Displays the snapshot at the given index.
   *
   * @param index the index of the snapshot to display.
   */
  public void jumpToSnapshot(int index) {
    if (index >= 0 && index < model.getSnapshotAlbum().getSnapshots().size()) {
      displaySnapshot(index);
    } else {
      JOptionPane.showMessageDialog(this, "No such snapshot.");
    }
  }
}
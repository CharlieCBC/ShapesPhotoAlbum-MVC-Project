package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import model.Model;
import model.Snapshot;
import model.IShape;
public class SnapshotAlbumView extends JFrame {
  private final Model model;
  private final DrawingPanel drawingPanel;
  private int currentIndex;
  private final JLabel snapshotTimestampAndDescription;

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
  private void displaySnapshot(int index) {
    if (index >= 0 && index < model.getSnapshotAlbum().getSnapshots().size()) {
      currentIndex = index;
      Snapshot snapshot = model.getSnapshotAlbum().getSnapshots().get(index);
      drawingPanel.setSnapshot(snapshot);

      // Update the timestamp and description JLabel
      snapshotTimestampAndDescription.setText(snapshot.getTimeStamp() + ": " + snapshot.getDescription());

      repaint();
    }
  }
  private void previousSnapshot() {
    if (currentIndex > 0) {
      displaySnapshot(currentIndex - 1);
    } else {
      JOptionPane.showMessageDialog(this, "No previous snapshot.");
    }
  }
  private void nextSnapshot() {
    if (currentIndex < model.getSnapshotAlbum().getSnapshots().size() - 1) {
      displaySnapshot(currentIndex + 1);
    } else {
      JOptionPane.showMessageDialog(this, "No further snapshots.");
    }
  }
  private void jumpToSnapshot(int index) {
    if (index >= 0 && index < model.getSnapshotAlbum().getSnapshots().size()) {
      displaySnapshot(index);
    } else {
      JOptionPane.showMessageDialog(this, "No such snapshot.");
    }
  }

  static class DrawingPanel extends JPanel {
    private Snapshot snapshot;

    public DrawingPanel() {
      setPreferredSize(new Dimension(400, 300));
    }

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
}
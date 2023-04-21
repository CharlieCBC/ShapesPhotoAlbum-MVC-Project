# CS5004-HW9
CS5004 HW9

## Refractors:

Modified the `Snapshot` class to make each snapshot store a list of shapes at the moment it was taken.

Modified the `SnapshotAlbum` class to make method takeSnapshot create new instance of shape album for snapshot.

Added an interface `ISnapshotAlbumModel` and a concrete model class to perform all the operations.

Added interfaces for `ShapeAlbum`, `Snapshot`, `SnapshotAlbum` classes.

Added colour and point attributes to the `Oval` class.

Added draw and toSVG in IShape to support graphic rendering in views, and reflected changes in subclasses.

Added toAWTColor in colour to convert rgb values, as well as overriding equals and hashcode.

## Controller Implementation:

The controller interacts with the model `SnapshotAlbumModel` and is responsible for reading commands from a file, updating the model, and printing the text representations of snapshots.

The controller initializes a model instance, and read through a command file and updates the model accordingly.

The printSnapshots method prints an overview of the snapshots taken by the model.

## View Implementations:

### Graphical:

The Graphical view consists of two classes: `SnapshotAlbumView` and `DrawingPanel`. 

The `SnapshotAlbumView` class extends JFrame and implements the `ISnapshotAlbumView` interface. It provides a GUI for displaying snapshots from the `SnapshotAlbumModel` and allows users to navigate through the snapshots using buttons and a JComboBox.

The `DrawingPanel` class extends JPanel, and  is a helper class used by `SnapshotAlbumView` to render the shapes in a snapshot.
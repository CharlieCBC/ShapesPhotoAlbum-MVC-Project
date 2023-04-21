# CS5004-HW9
CS5004 HW9

## Refactors:

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

#### SnapshotAlbumView: 

The `SnapshotAlbumView` class extends JFrame and implements the `ISnapshotAlbumView` interface. It provides a GUI for displaying snapshots from the `SnapshotAlbumModel` and allows users to navigate through the snapshots using buttons and a JComboBox.

In `SnapshotAlbumView`, it has several private attributes including model for holding the `SnapshotAlbumModel`, a `DrawingPanel` object called drawingPanel, an int called currentIndex to keep track of the current snapshot, and a JLabel called snapshotTimestampAndDescription for displaying the snapshot's timestamp and description.
The constructor initializes the model, sets up the JFrame, and adds components such as buttons, a JComboBox, and a JLabel. It also defines action listeners for the buttons and JComboBox.
The displaySnapshot method takes an index as input and displays the corresponding snapshot. It sets the snapshot for the drawingPanel and updates the snapshotTimestampAndDescription label.
The method previousSnapshot, nextSnapshot, and jumpToSnapshot support functionalities of displaying previous, next, and specified snapshot on demand.

#### DrawingPanel:

The `DrawingPanel` class extends JPanel, and  is a helper class used by `SnapshotAlbumView` to render the shapes in a snapshot.

In `DrawingPanel`, it has a private `Snapshot` object called snapshot.
The constructor sets a default preferred size of the panel.
The setSnapshot method takes a `Snapshot` object as input and sets it as the snapshot to display, then calls repaint() to refresh the panel.
The paintComponent method is overridden to paint the shapes in the snapshot on the panel.

### Web:

The `HTMLSnapshotAlbumExporter` class provides functionality to generate an HTML file containing an SVG representation of a snapshot album, and save the HTML file.

The generateHTML method takes a `SnapshotAlbumModel` object, a width, and a height as input parameters. Then it generates an HTML file containing SVG for each snapshot in the model. The method does this by looping through all the snapshots in the model, appending the appropriate HTML and SVG to a StringBuilder. It creates an SVG viewbox with the given width and height and converts each shape in the snapshot to SVG using the toSVG() method of the IShape interface. The generated HTML string is returned at the end.

Then, saveHTMLToFile method takes a generated HTML string and a filename as input parameters. It saves the HTML string to a file with the specified filename using a FileWriter. If an exception occurs while writing the file, the method prints an error message.

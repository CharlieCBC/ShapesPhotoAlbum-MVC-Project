# CS5004-HW9
CS5004 HW9

## Refractors:

Modified the Snapshot class to make each snapshot store a list of shapes at the moment it was taken.

Modified the SnapshotAlbum class to make method takeSnapshot create new instance of shape album for snapshot.

Added an interface IModel and a concrete model class to perform all the operations.

Added colour and point attributes to the Oval class.

Added draw and toSVG in IShape to support graphic rendering in views, and reflected changes in subclasses.

Added toAWTColor in colour to convert rgb values.
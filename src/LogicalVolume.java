public class LogicalVolume extends LVM implements Comparable<LogicalVolume> {

    private VolumeGroup associatedVG;
    private double size;

    public LogicalVolume(String n, VolumeGroup vg, double s) {
        super(n);
        associatedVG = vg;
        size = s;
    }

    public double getSize() {
        return size;
    }

    public VolumeGroup getAssociatedVG() {
        return associatedVG;
    }

    public int compareTo(LogicalVolume vol) {

        return this.associatedVG.getName().compareTo(vol.getAssociatedVG().getName());

    }
}

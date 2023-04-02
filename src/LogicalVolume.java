public class LogicalVolume extends LVM{

    private VolumeGroup associatedVG;
    private double size;

    public LogicalVolume(String n, VolumeGroup vg, double s) {
        super(n);
        associatedVG = vg;
        size = s;
    }
}

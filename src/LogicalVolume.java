public class LogicalVolume extends LVM{

    VolumeGroup associatedVG;
    double size;

    public LogicalVolume(String n, VolumeGroup vg, double s) {
        super(n);
        associatedVG = vg;
        size = s;
    }
}

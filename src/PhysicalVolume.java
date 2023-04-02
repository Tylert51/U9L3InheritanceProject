public class PhysicalVolume extends LVM{

    private PhysicalDrive physicalDrive;
    private VolumeGroup associatedVG;

    public PhysicalVolume(String n, PhysicalDrive d) {
        super(n);
        physicalDrive = d;
        associatedVG = null;
    }

    public PhysicalDrive getPhysicalDrive() {
        return physicalDrive;
    }

    public void addVG(VolumeGroup vg) {
        associatedVG = vg;
    }

    public boolean doesHaveVG() {
        return associatedVG != null;
    }

    public VolumeGroup getAssociatedVG() {
        return associatedVG;
    }

}

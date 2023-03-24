public class PhysicalVolume extends LVM{

    PhysicalDrive physicalDrive;

    public PhysicalVolume(String n, PhysicalDrive d) {
        super(n);
        physicalDrive = d;
    }
}

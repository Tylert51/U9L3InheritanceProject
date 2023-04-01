public class PhysicalDrive extends LVM {

    int size;

    public PhysicalDrive(String name, int s) {
        super(name);
        size = s;
    }

    public int getSize() {
        return size;
    }

}

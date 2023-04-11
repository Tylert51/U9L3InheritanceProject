import java.io.Serializable;

public class PhysicalDrive extends LVM implements Serializable {

    private int size;

    public PhysicalDrive(String name, int s) {
        super(name);
        size = s;
    }

    public int getSize() {
        return size;
    }

}

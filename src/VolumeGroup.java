import java.io.Serializable;
import java.util.ArrayList;

public class VolumeGroup extends LVM implements Serializable {

    private ArrayList<PhysicalVolume> listOfPV;
    private ArrayList<LogicalVolume> listOfLV;

    public VolumeGroup(String s) {
        super(s);

        listOfPV = new ArrayList<PhysicalVolume>();
        listOfLV = new ArrayList<LogicalVolume>();
    }

    public void addPV(PhysicalVolume pv) {
        listOfPV.add(pv);
    }

    public void addLV(LogicalVolume lv) {
        listOfLV.add(lv);
    }

    public int getTotalSpace() {
        int space = 0;

        for(PhysicalVolume pv : listOfPV) {

            space += pv.getPhysicalDrive().getSize();

        }

        return space;
    }

    public double getRemainingSpace() {
        double total = getTotalSpace();

        for(LogicalVolume lv : listOfLV) {
            total -= lv.getSize();

        }

        return total;
    }

    public String listPVs() {
        String str = "";

        for(PhysicalVolume pv : listOfPV) {
            str += pv.getName() + ",";
        }

        str = str.substring(0, str.length() - 1);

        return str;
    }

}

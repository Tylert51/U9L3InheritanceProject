import java.util.ArrayList;

public class LVMSystem {

    ArrayList<PhysicalDrive> listOfPD;
    ArrayList<PhysicalVolume> listOfPV;
    ArrayList<VolumeGroup> listOfVG;
    ArrayList<LogicalVolume> listOfLV;

    public LVMSystem() {
        listOfPD = new ArrayList<PhysicalDrive>();
        listOfPV = new ArrayList<PhysicalVolume>();
        listOfVG = new ArrayList<VolumeGroup>();
        listOfLV = new ArrayList<LogicalVolume>();
    }

    public boolean doesContainPD(PhysicalDrive p) {
        return listOfPD.contains(p);
    }

    public boolean doesContainPV(PhysicalVolume p) {
        return listOfPV.contains(p);
    }

    public boolean doesContainVG(VolumeGroup v) {
        return listOfVG.contains(v);
    }

    public boolean doesContainLV(LogicalVolume l) {
        return listOfLV.contains(l);
    }


}

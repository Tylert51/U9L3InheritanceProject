import java.util.ArrayList;

public class LVMSystem {

    private ArrayList<PhysicalDrive> listOfPD;
    private ArrayList<PhysicalVolume> listOfPV;
    private ArrayList<VolumeGroup> listOfVG;
    private ArrayList<LogicalVolume> listOfLV;

    public LVMSystem() {
        listOfPD = new ArrayList<PhysicalDrive>();
        listOfPV = new ArrayList<PhysicalVolume>();
        listOfVG = new ArrayList<VolumeGroup>();
        listOfLV = new ArrayList<LogicalVolume>();
    }

    public boolean doesNotContainPD(String n) {

        for(PhysicalDrive drive : listOfPD) {
            String name = drive.getName();

            if(name.equals(n)) {
                return false;
            }
        }

        return true;
    }

    public boolean doesNotContainPV(String n) {

        for(PhysicalVolume volume : listOfPV) {
            String name = volume.getName();

            if(name.equals(n)) {
                return false;
            }
        }

        return true;
    }

    public boolean doesNotContainVG(String n) {

        for(VolumeGroup group : listOfVG) {
            String name = group.getName();

            if(name.equals(n)) {
                return false;
            }
        }

        return true;
    }

    public boolean doesNotContainLV(String n) {

        for(LogicalVolume volume : listOfLV) {
            String name = volume.getName();

            if(name.equals(n)) {
                return false;
            }
        }

        return true;
    }

    public void addPD(PhysicalDrive p) {
        listOfPD.add(p);
    }

    public void addPV(PhysicalVolume p) {
        listOfPV.add(p);
    }

    public void addVG(VolumeGroup v) {
        listOfVG.add(v);
    }

    public void addLV(LogicalVolume l) {
        listOfLV.add(l);
    }

    public ArrayList<PhysicalDrive> getListOfPD() {
        return listOfPD;
    }

    public ArrayList<PhysicalVolume> getListOfPV() {
        return listOfPV;
    }

    public ArrayList<VolumeGroup> getListOfVG() {
        return listOfVG;
    }

    public ArrayList<LogicalVolume> getListOfLV() {
        return listOfLV;
    }

    public PhysicalDrive getPD(String n) {
        for(PhysicalDrive drive : listOfPD) {
            String name = drive.getName();

            if(name.equals(n)) {
                return drive;
            }
        }

        return null;
    }

    public ArrayList<PhysicalDrive> getUsedDrives() {
        ArrayList<PhysicalDrive> used = new ArrayList<>();

        for(PhysicalVolume vol : listOfPV) {
            used.add(vol.getPhysicalDrive());
        }

        return used;
    }
}

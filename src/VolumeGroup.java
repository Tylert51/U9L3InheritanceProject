import java.util.ArrayList;

public class VolumeGroup extends LVM{

    ArrayList<PhysicalVolume> listOfPV;
    ArrayList<LogicalVolume> listOfLV;

    public VolumeGroup(String s) {
        super(s);

        listOfPV = new ArrayList<PhysicalVolume>();
        listOfLV = new ArrayList<LogicalVolume>();
    }

}

import java.util.ArrayList;

public class VolumeGroup extends LVM{

    private ArrayList<PhysicalVolume> listOfPV;
    private ArrayList<LogicalVolume> listOfLV;

    public VolumeGroup(String s) {
        super(s);

        listOfPV = new ArrayList<PhysicalVolume>();
        listOfLV = new ArrayList<LogicalVolume>();
    }

}

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileWriter {

    public void writeFile(LVMSystem manager) throws IOException {

        ArrayList<PhysicalDrive> pd = manager.getListOfPD();
        ArrayList<PhysicalVolume> pv = manager.getListOfPV();
        ArrayList<VolumeGroup> vg = manager.getListOfVG();
        ArrayList<LogicalVolume> lv = manager.getListOfLV();


        FileOutputStream fos = new FileOutputStream("LVM.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(pd);
        oos.writeObject(pv);
        oos.writeObject(vg);
        oos.writeObject(lv);

        oos.close();
        fos.close();
    }

    public void readFile(LVMSystem manager) throws IOException, ClassNotFoundException {

        FileInputStream fi = new FileInputStream("LVM.txt");
        ObjectInputStream oi = new ObjectInputStream(fi);

        ArrayList<PhysicalDrive> pd = new ArrayList<PhysicalDrive>();
        ArrayList<PhysicalVolume> pv = new ArrayList<PhysicalVolume>();
        ArrayList<VolumeGroup> vg = new ArrayList<VolumeGroup>();
        ArrayList<LogicalVolume> lv = new ArrayList<LogicalVolume>();

        // Read objects
        pd = (ArrayList<PhysicalDrive>) oi.readObject();
        pv = (ArrayList<PhysicalVolume>) oi.readObject();
        vg = (ArrayList<VolumeGroup>) oi.readObject();
        lv = (ArrayList<LogicalVolume>) oi.readObject();

        manager.setLists(pd, pv, vg, lv);

        oi.close();
        fi.close();
    }

}

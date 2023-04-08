import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileWriter {

    public void writeFile(ArrayList<PhysicalDrive> pd, ArrayList<PhysicalVolume> pv, ArrayList<VolumeGroup> vg, ArrayList<LogicalVolume> lv) {

        try {
            FileOutputStream f = new FileOutputStream(new File("LVM.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            for (PhysicalDrive drive : pd) {
                o.writeObject(drive);
            }

            for (PhysicalVolume vol : pv) {
                o.writeObject(vol);
            }

            for (VolumeGroup group : vg) {
                o.writeObject(group);
            }

            for (LogicalVolume vol : lv) {
                o.writeObject(vol);
            }

            o.close();
            f.close();


            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Person pr1 = (Person) oi.readObject();
            Person pr2 = (Person) oi.readObject();


            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (IOException e) {
            System.out.println("Error initializing stream");

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

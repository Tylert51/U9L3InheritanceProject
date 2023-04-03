import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Runner {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        LVMSystem manager = new LVMSystem();

        System.out.println("Welcome to the LVM System\n");
        System.out.print("cmd #: ");
        String ans = s.nextLine();

        while (!ans.equals("exit")) {


            if(ans.contains("install-drive")) {

                installDrive(ans, manager);

            } else if (ans.contains("list-drives")) {

                printDrives(manager);

            } else if (ans.contains("pvcreate")) {

                installPV(ans, manager);

            } else if (ans.contains("pvlist")) {

                printPVolumes(manager);

            } else if (ans.contains("vgcreate")) {

                createVG(ans, manager);

            } else if (ans.contains("vgextend")) {

                extendVG(ans, manager);

            } else if (ans.contains("vglist")) {

                listVG(manager);

            }


            System.out.print("\ncmd #: ");
            ans = s.nextLine();
        }


    }

    public static void installDrive(String ans, LVMSystem manager) {

        String subStr = ans.substring(14);

        String[] parts = subStr.split(" ");

        if (manager.doesNotContainPD(parts[0])) {

            int size = Integer.parseInt(parts[1].substring(0, parts[1].indexOf("G")));
            PhysicalDrive pD = new PhysicalDrive(parts[0], size);

            manager.addPD(pD);

            System.out.println("Drive " + parts[0] +  " installed");
        } else {
            System.out.println("Already a drive installed with that name");
        }
    }

    public static void printDrives(LVMSystem manager) {
        ArrayList<PhysicalDrive> listOfPD = manager.getListOfPD();

        if(listOfPD.size() >= 1) {
            for (PhysicalDrive drive : listOfPD) {
                System.out.println(drive.getName() + " [" + drive.getSize() + "G] [" + drive.getUUID() + "]");
            }
        } else {
            System.out.println("No physical drives installed");
        }

    }

    public static void installPV(String ans, LVMSystem manager) {

        String sub = ans.substring(9);

        String[] parts = sub.split(" ");
        PhysicalDrive associated = manager.getPD(parts[1]);

        ArrayList<PhysicalDrive> usedDrives = manager.getUsedDrives();

        if(associated == null) {
            System.out.println("There is no such physical drive\nFailed to create physical volume");

        } else if (manager.doesContainPV(parts[0])) {
            System.out.println("Already a physical volume with that name");

        } else if (usedDrives.contains(associated)) {
            System.out.println("Already a physical volume associate with that drive");

        } else {

            PhysicalVolume pV = new PhysicalVolume(parts[0], associated);
            System.out.println(parts[0] + " created");

            manager.addPV(pV);
        }

    }

    public static void printPVolumes(LVMSystem manager) {
        ArrayList<PhysicalVolume> listOfPV = manager.getListOfPV();

        if(listOfPV.size() >= 1) {
            for(PhysicalVolume vol : listOfPV) {

                if(!vol.doesHaveVG()) {
                    System.out.println(vol.getName() + ": [" + vol.getPhysicalDrive().getSize() + "G] [" + vol.getUUID() + "]");

                } else {
                    System.out.println(vol.getName() + ": [" + vol.getPhysicalDrive().getSize() + "G] " +
                            "[" + vol.getAssociatedVG().getName() + "] [" + vol.getUUID() + "]");

                }
            }
        } else {
            System.out.println("No physical volumes have been created");
        }
    }

    public static void createVG(String ans, LVMSystem manager) {
        String sub = ans.substring(9);
        String[] split = sub.split(" ");

        String vgName = split[0];
        String pvName = split[1];
        PhysicalVolume associated = manager.getPV(pvName);

        ArrayList<PhysicalVolume> usedPV = manager.getUsedPV();

        if(manager.doesContainVG(vgName)) {
            System.out.println("Already a volume group with that name");

        } else if (usedPV.contains(associated)) {
            System.out.println("That physical volume is already associated with a volume group");

        } else if (associated == null) {
            System.out.println("There is no such physical volume");

        } else {
            VolumeGroup vg = new VolumeGroup(vgName);
            vg.addPV(associated);
            associated.addVG(vg);

            manager.addVG(vg);
            System.out.println(vgName + " created");
        }
    }

    public static void extendVG(String ans, LVMSystem manager) {
        String sub = ans.substring(9);
        String[] split = sub.split(" ");

        String vgName = split[0];
        String pvName = split[1];
        VolumeGroup vg = manager.getVG(vgName);
        PhysicalVolume pv = manager.getPV(pvName);

        ArrayList<PhysicalVolume> usedPV = manager.getUsedPV();

        if(vg == null) {
            System.out.println("There is no such volume group");

        } else if (pv == null) {
            System.out.println("There is no such physical volume");

        } else if (usedPV.contains(pv)) {
            System.out.println("That physical volume is already associate with another volume group");

        } else {
            vg.addPV(pv);
            pv.addVG(vg);
            System.out.println(pvName + " added to " + vgName);

        }
    }

    public static void listVG(LVMSystem manager) {
        ArrayList<VolumeGroup> listOfVG = manager.getListOfVG();

        for(VolumeGroup vg : listOfVG) {

            System.out.println(vg.getName() + ": total:[" + vg.getTotalSpace() + "G] " +
                    "available:[" + vg.getRemainingSpace() + "G] [" + vg.listPVs() + "] " +
                    "[" + vg.getUUID() + "]");

        }

    }
}

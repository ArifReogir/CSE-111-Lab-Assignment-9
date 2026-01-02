/*Your task is to design the UpsideDown class with appropriate variables and methods such that the following tester code produces the expected output.
Note: 
>> Assume that each gate of  UpsideDown can connect with two bridges.
>> You cannot use any arrays in the  UpsideDown class.
>> You should use the given Hawkins and DarkDimension classes’ variables and methods as needed.
>> You cannot modify the given Hawkins and DarkDimension  classes. */

public class HawkinsLabTester { // Driver code
    public static void main(String[] args) {
        Hawkins place1 = new Hawkins("Hawkins Lab");
        Hawkins place2 = new Hawkins("Palace Arcade");
        UpsideDown gate1 = new UpsideDown("The Nina Project");
        UpsideDown gate2 = new UpsideDown("Brimborn Steel Works");
        DarkDimension world = new DarkDimension("The Dark World");
        gate1.open();
        System.out.println("Total bridges: " + UpsideDown.totalBridges);
        System.out.println("======== [1] ========");
        gate1.connect(place1);
        gate1.connect(place2);
        Hawkins place3 = new Hawkins("Starcourt Mall");
        gate2.connect(place3);
        gate1.details();
        gate2.details();
        System.out.println("======== [2] ========");
        world.runExperiment(gate1);
        world.runExperiment(gate2);
        System.out.println("======== [3] ========");
        System.out.println("Total bridges: " + UpsideDown.totalBridges);
        System.out.println("======== [4] ========");
        Hawkins place4 = new Hawkins("Byers new house");
        gate1.connect(place4);
        gate1.disconnect(2);
        gate2.disconnect(3);
        System.out.println("======== [5] ========");
        gate1.details();
    }
}

// Class starts here

class Hawkins { // Grand Parent class
    public String name;
    public boolean status = false;

    public Hawkins(String name) {
        this.name = name;
    }

    public boolean checkBridge(Hawkins h) {
        if (h.status == true) {
            System.out.println("Bridge present at " + h.name);
            return true;
        } else {
            System.out.println("No Bridge present at " + h.name);
            return false;
        }
    }

    public void open() {
        if (status == false) {
            status = true;
            System.out.println("Bridge from " + name + " is Open");
        }
    }
}

class UpsideDown extends Hawkins { // Parent class
    private Hawkins bridge1;
    private Hawkins bridge2;

    public static int totalBridges;

    public UpsideDown(String name) {
        super(name);
    }

    public void connect(Hawkins x) {
        if (bridge1 == null) {
            bridge1 = x;
            totalBridges++;
        } else if (bridge2 == null) {
            bridge2 = x;
            totalBridges++;
        } else {
            System.out.println("No further bridges with " + name);
        }
    }

    public void disconnect(int a) {
        if (a == 1 && bridge1 != null) {
            bridge1.status = false;
            bridge1 = null;
            totalBridges--;
        } else if (a == 2 && bridge2 != null) {
            bridge2.status = false;
            bridge2 = null;
            totalBridges--;
        } else {
            System.out.println("Invalid bridge number!");
        }
    }

    public String getBridge1() {
        if (bridge1 == null) {
            return null;
        }

        return bridge1.name;
    }

    public String getBridge2() {
        if (bridge2 == null) {
            return null;
        }

        return bridge2.name;
    }

    public void activate(String place) {
        System.out.println("Activating the door of " + place);
    }

    public void details() {
        System.out.println(name + " Details: ");
        if (bridge1 != null) {
            System.out.println("Bridge 1: " + bridge1.name);
        }
        if (bridge2 != null) {
            System.out.println("Bridge 2: " + bridge2.name);
        }
    }

}

class DarkDimension extends UpsideDown { // Child class
    public DarkDimension(String name) {
        super(name);
    }

    public void runExperiment(UpsideDown portal) {
        if (!this.checkBridge(portal)) {
            System.out.println("Cannot run experiment.");
        } else {
            if (portal.getBridge1() != null) {
                portal.activate(portal.getBridge1());
                System.out.println("Experiment executed successfully!");
            } else if (portal.getBridge2() != null) {
                portal.activate(portal.getBridge2());
                System.out.println("Experiment executed successfully!");
            } else {
                System.out.println("No experiment found!");
            }
        }
    }
}

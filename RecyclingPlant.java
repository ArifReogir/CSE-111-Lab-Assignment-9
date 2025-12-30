/*Write the UsedBattery and the PlasticBottle classes derived from Waste class so that the following code generates the output below.

You also need to complete the SorterBot class for this code to work. You cannot create any additional methods in the SorterBot class.
 */

public class RecyclingPlant { // Driver code
    public static void main(String[] args) {
        SorterBot robot = new SorterBot();
        UsedBattery bat1 = new UsedBattery("Duracell-X", true);
        PlasticBottle bot1 = new PlasticBottle("Coke-Zero", 500);
        Waste unknown = new Waste("Mystery-Box");
        System.out.println("#######################");
        robot.processItem(bat1);
        robot.processItem(bot1);
        robot.processItem(unknown);
        robot.processItem(new UsedBattery("Energizer", false));
    }
}

// Class starts here

class Waste { // Parent class
    String id;

    Waste(String id) {
        this.id = id;
    }
}

class UsedBattery extends Waste { // Child class
    public boolean status;
    public String type = "BATTERY";

    public UsedBattery(String name, boolean status) {
        super(name);
        this.status = status;
    }
}

class PlasticBottle extends Waste { // Child class
    public String type = "PLASTIC";
    public int capacity;

    public PlasticBottle(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }
}

class SorterBot { // Disjoint class
    public void processItem(Waste item) {

        if (item instanceof UsedBattery) {
            UsedBattery b = (UsedBattery) item;

            System.out.println("Scanning Item " + b.id + " [Type: " + b.type + "]");

            if (b.status == true) {
                System.out.println(b.id + " is leaking. Sealing in the concrete container.");
            } else {
                System.out.println(b.id + " stored in a dry cell.");
            }

        }

        else if (item instanceof PlasticBottle) {
            PlasticBottle c = (PlasticBottle) item;

            System.out.println("Scanning Item " + c.id + " [Type: " + c.type + "]");

            System.out.println(c.id + " compressed from " + c.capacity + "ml to flat disk.");
        }

        else {
            System.out.println("Scanning Item " + item.id + " [Type: UNKNOWN]");
            System.out.println("Item sent to generic incinerator.");
        }
        System.out.println("-------------------------------");
    }
}

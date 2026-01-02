/*Write the Garage, Bike and Car class. Car, Bike are child classes of Vehicle class. But Garage is neither a parent nor a child class. The Garage class has two arrays as instance variables called cars and bikes that can store Car and Bike objects.

Hint: In this task you’ll need to use the instanceof keyword and downcasting. */

public class GarageTester {
    public static void main(String[] args) { // Driver code
        Garage g = new Garage(2, 3);
        System.out.println("==========0===========");
        Vehicle vC1 = new Car("Ford", "Mustang", 2022, 2, 4, false);
        Vehicle vC2 = new Car("Tesla", "Model S", 2025, 4, 4, true);
        Vehicle vC3 = new Car("Reliant", "Robin", 1981, 2, 3, false);
        System.out.println("==========1===========");
        System.out.println(vC1);
        System.out.println("==========2===========");
        g.addVehicle(vC1);
        g.addVehicle(vC2);
        g.addVehicle(vC3);
        System.out.println(g.cars[1]);
        System.out.println("==========3===========");
        g.cars[0].startAutoPilot();
        g.cars[1].startAutoPilot();
        System.out.println("==========4===========");
        Vehicle vB1 = new Bike("Honda", "Gold Wing", 2022, 3, true);
        System.out.println(vB1);
        g.addVehicle(vB1);
        System.out.println("==========5===========");
        Vehicle vB2 = new Bike("Royal Enfield", "Classic 350", 2021, 2, false);
        g.addVehicle(vB2);
        System.out.println(g.bikes[1]);
        System.out.println("==========6===========");
        Vehicle vB3 = new Bike("Harley-Davidson", "Street 750", 2022, 2, false);
        g.addVehicle(vB3);
        Vehicle vB4 = new Bike("Yamaha", "MT-15", 2023, 2, false);
        g.addVehicle(vB4);
        System.out.println("=========7============");
        g.bikes[0].doAWheelie();
        g.bikes[1].doAWheelie();

    }
}

// Class starts here

class Garage {
    public Car[] cars;
    public Bike[] bikes;
    public int cars_count;
    public int bikes_count;

    public Garage(int x, int y) {
        cars = new Car[x];
        bikes = new Bike[y];
        System.out.println("Welcome to the Garage!");
        System.out.println("Car Capacity: " + x);
        System.out.println("Bike Capacity: " + y);
    }

    public void addVehicle(Vehicle h) {
        if (h instanceof Car) {
            if (cars_count < cars.length) {
                cars[cars_count] = (Car) h;
                cars_count++;
                System.out.println("A " + h.getBrand() + " CAR has been to the Garage");
            } else {
                System.out.println("Can't add more Cars! Capacity: " + cars.length);
            }
        }

        else if (h instanceof Bike) {
            if (bikes_count < bikes.length) {
                bikes[bikes_count] = (Bike) h;
                bikes_count++;
                System.out.println("A " + h.getBrand() + " BIKE has been added to the Garage");
            } else {
                System.out.println("Can't add more bikes! Capacity: " + bikes.length);
            }
        }
    }
}

class Vehicle { // Parent class

    private String brand;
    private int year, wheels;

    public Vehicle(String b, int y) {
        this.brand = b;
        this.year = y;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getYear() {
        return this.year;
    }

    public void setWheels(int w) {
        this.wheels = w;
    }

    public int getWheels() {
        return this.wheels;
    }

    public String toString() {
        return "Brand: " + this.brand + ", Year: " + this.year + ", Wheels: " + this.wheels;
    }

}

class Car extends Vehicle { // Child class
    public String model;
    public int doors;
    public boolean AI;

    public Car(String brand, String model, int year, int doors, int wheels, boolean Ai) {
        super(brand, year);
        this.model = model;
        this.doors = doors;
        this.AI = Ai;

        setWheels(wheels);
    }

    public void startAutoPilot() {
        if (AI == false) {
            System.out.println(getBrand() + ":" + model + " has NO AutoPilot");
        } else {
            System.out.println(getBrand() + ":" + model + " AutoPilot Started");
        }
    }

    public String toString() {
        return "Car " + super.toString() + ", Model: " + model + ", Doors: " + doors + ", AI: " + AI;
    }
}

class Bike extends Vehicle { // Child class
    public String model;
    public boolean sidecars;

    public Bike(String brand, String model, int year, int wheels, boolean sidecars) {
        super(brand, year);
        this.model = model;
        this.sidecars = sidecars;

        setWheels(wheels);
    }

    public void doAWheelie() {
        if (sidecars == true) {
            System.out.println("Wheelie Failed. " + getBrand() + ":" + model + " has a SideCar");
        } else {
            System.out.println(getBrand() + ":" + model + " is doing Wheelie!!");
        }
    }

    public String toString() {
        return "Bike " + super.toString() + ", Model: " + model + ", SideCar: " + sidecars;
    }
}
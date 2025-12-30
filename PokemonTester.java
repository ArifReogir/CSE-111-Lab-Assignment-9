/* Write the Pokemon class so that the following code generates the output below: */

public class PokemonTester { // Driver code
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu");
        pikachu.attack();
        pikachu.attack("Thunderbolt");
        pikachu.attack("Iron Tail", 90);
    }
}

// Class starts here

class Pokemon {
    public String name;

    public Pokemon(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println(name + " attacks with a basic move!");
    }

    public void attack(String move) {
        System.out.println(name + " uses " + move + "!");
    }

    public void attack(String move, int power) {
        System.out.println("Pokemon uses " + move + " with power " + power + "!");
    }
}

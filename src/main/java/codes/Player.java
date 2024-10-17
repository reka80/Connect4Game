package codes;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;  // Játékos neve
    private char disc;  // Játékos korongja (Y vagy R)
    private boolean isHuman;  // Játékos típusa (humán vagy gépi)
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public Player(String name, char disc, boolean isHuman) {
        this.name = name;
        this.disc = disc;
        this.isHuman = isHuman;
    }

    public String getName() {
        return name;
    }

    public char getDisc() {
        return disc;
    }

    public boolean isHuman() {
        return isHuman;
    }

    // Humán játékos választ egy oszlopot
    public int chooseColumn() {
        if (isHuman) {
            System.out.print("Válassz egy oszlopot (a-g): ");
            char input = scanner.next().charAt(0);
            return input - 'a';  // Az oszlop betűjének konvertálása indexre
        } else {
            return random.nextInt(7);  // Gép véletlenszerűen választ egy oszlopot
        }
    }
}

import java.util.Scanner;
import java.util.Random;

public class D20HyperRoll {
    int[] d20 = new int[20];
    Random rand = new Random();

    public D20HyperRoll() {
        refresh();
    }

    public static void main(String[] args) {
        D20HyperRoll roll = new D20HyperRoll();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - ROLL");
            System.out.println("2 - Show avilable values");
            System.out.println("3 - Refresh die");
            System.out.println("4 - Exit");
            System.out.print("Enter a choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    roll.roll();
                    break;
                case 2:
                    roll.displayArray();
                    break;
                case 3:
                    roll.refresh();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }


    public void roll() {
        int randomIndex = rand.nextInt(d20.length);
        while (d20[randomIndex] == 0) {
            randomIndex = rand.nextInt(d20.length);
        }
        System.out.println("You rolled: " + d20[randomIndex]);
        d20[randomIndex] = 0;
    }

    public void displayArray() {
        for (int i : d20) {
            if (i != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public void refresh() {
        for (int i = 0; i < d20.length; i++) {
            d20[i] = i + 1;
        }
    }
}
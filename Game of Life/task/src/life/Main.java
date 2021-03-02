package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int universeSize = scanner.nextInt();
        int seed = scanner. nextInt();
        startUniverse(universeSize, seed);
    }

    public static void startUniverse(int size, int seed) {
        Random random = new Random(seed);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (random.nextBoolean())
                    System.out.print("O");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}

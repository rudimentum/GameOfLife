package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int universeSize = scanner.nextInt();
        long seed = scanner. nextLong();
        int numberOfGenerations = scanner.nextInt();
        Algorithm algorithm = new Algorithm(numberOfGenerations, universeSize, seed);
        UniverseState universeState = algorithm.createUniverse();
        universeState.print();

    }

    public static void process(String[][] curGeneration, int numberOfGenerations) {
        for (int i = 0; i < numberOfGenerations; i++) {
        }
    }

}

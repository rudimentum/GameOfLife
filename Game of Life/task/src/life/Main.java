package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int universeSize = scanner.nextInt();
        long seed = scanner. nextLong();
        int numberOfGenerations = scanner.nextInt();
        Algorithm algorithm = new Algorithm(numberOfGenerations, universeSize, seed);
        UniverseState universe = process(algorithm);
        universe.print();
    }

    public static UniverseState process(Algorithm algorithm) {
        int numberOfGenerations = algorithm.getNumberOfGenerations();
        UniverseState universe = algorithm.createUniverse();
        for (int i = 0; i < numberOfGenerations; i++) {
            universe = algorithm.computeNextGeneration(universe);
        }
        return universe;
    }
}

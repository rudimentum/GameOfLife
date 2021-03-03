package life;

import java.util.Random;

public class Algorithm {
    private final int numberOfGenerations;
    private final int size;
    private final long seed;
    private UniverseState generation;
    private UniverseState nextGeneration;

    public Algorithm(int numberOfGenerations, int size, long seed) {
        this.numberOfGenerations = numberOfGenerations;
        this.size = size;
        this.seed = seed;
    }

    public UniverseState createUniverse() {
        String[][] universe = new String[size][size];
        Random random = new Random(seed);
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe[i].length; j++) {
                if (random.nextBoolean())
                    universe[i][j] = "O";
                else
                    universe[i][j] = " ";
            }
        }
        UniverseState universeState = new UniverseState(universe);
        return universeState;
    }

    public UniverseState computeNextGeneration() {

        for (int i = 0; i < numberOfGenerations; i++) {
        }
        return null;
    }
}

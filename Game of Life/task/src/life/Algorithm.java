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

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public UniverseState getGeneration() {
        return generation;
    }

    public UniverseState getNextGeneration() {
        return nextGeneration;
    }

    public UniverseState createUniverse() {
        char[][] universe = new char[size][size];
        Random random = new Random(seed);
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe[i].length; j++) {
                if (random.nextBoolean())
                    universe[i][j] = 'O';
                else
                    universe[i][j] = ' ';
            }
        }
        return new UniverseState(universe);
    }

    public UniverseState computeNextGeneration() {
        generation = createUniverse();
        nextGeneration = generation;

        char[][] temp = generation.getUniverse();
        for (int j = 0; j < temp.length; j++) {
            for (int k = 0; k < temp[j].length; k++) {
                int sumOfNeighbors = temp[--j][--k] + temp[--j][k] + temp[--j][++k] + temp[j][--k] + temp[j][++k] + temp[++j][--k] + temp[++j][k] + temp[++j][++k];
                if ('O' == temp[j][k]) {
                    if (sumOfNeighbors == 158 || sumOfNeighbors == 237) {
                        nextGeneration.getUniverse()[j][k] = 'O';
                    } else {
                        nextGeneration.getUniverse()[j][k] = ' ';
                    }
                } else {
                    if (sumOfNeighbors == 237) {
                        nextGeneration.getUniverse()[j][k] = 'O';
                    } else {
                        nextGeneration.getUniverse()[j][k] = ' ';
                    }
                }
            }
        }

        return nextGeneration;
    }
}

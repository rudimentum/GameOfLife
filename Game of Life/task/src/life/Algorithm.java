package life;

import java.util.Random;

public class Algorithm {
    private final int numberOfGenerations;
    private final int size;
    private final long seed;

    public Algorithm(int numberOfGenerations, int size, long seed) {
        this.numberOfGenerations = numberOfGenerations;
        this.size = size;
        this.seed = seed;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
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

    public UniverseState computeNextGeneration(UniverseState generation) {
        char[][] temp = generation.getUniverse();
        UniverseState nextGeneration = createUniverse();
        for (int row = 0; row < temp.length; row++) {
            for (int col = 0; col < temp[row].length; col++) {
                int last = temp.length - 1;
                char[] neighbors;
                if (row == last && col == last) {
                    neighbors = new char[]{temp[row - 1][col - 1], temp[row - 1][col], temp[row - 1][0], temp[row][col - 1],
                            temp[row][0], temp[0][col - 1], temp[0][col], temp[0][0]};
                } else if (row == last && col == 0) {
                    neighbors = new char[]{temp[row - 1][last], temp[row - 1][col], temp[row - 1][col + 1], temp[last][last],
                            temp[row][col + 1], temp[0][last], temp[0][col], temp[0][col + 1]};
                } else if (row == 0 && col == last) {
                    neighbors = new char[]{temp[last][col - 1], temp[last][last], temp[last][0], temp[row][col - 1],
                            temp[row][0], temp[row + 1][col - 1], temp[row + 1][col], temp[row + 1][0]};
                } else if (row == last) {
                    neighbors = new char[]{temp[row - 1][col - 1], temp[row - 1][col], temp[row - 1][col + 1], temp[row][col - 1],
                            temp[row][col + 1], temp[0][col - 1], temp[0][col], temp[0][col + 1]};
                } else if (col == last) {
                    neighbors = new char[]{temp[row - 1][col - 1], temp[row - 1][col], temp[row - 1][0], temp[row][col - 1],
                            temp[row][0], temp[row + 1][col - 1], temp[row + 1][col], temp[row + 1][0]};
                } else if (row == 0 && col == 0) {
                    neighbors = new char[]{temp[last][last], temp[last][col], temp[last][col + 1], temp[row][last],
                            temp[row][col + 1], temp[row + 1][last], temp[row + 1][col], temp[row + 1][col + 1]};
                } else if (row == 0) {
                    neighbors = new char[]{temp[last][col - 1], temp[last][col], temp[last][col + 1], temp[row][col - 1],
                            temp[row][col + 1], temp[row + 1][col - 1], temp[row + 1][col], temp[row + 1][col + 1]};
                } else if (col == 0) {
                    neighbors = new char[]{temp[row - 1][last], temp[row - 1][col], temp[row - 1][col + 1], temp[row][last],
                            temp[row][col + 1], temp[row + 1][last], temp[row + 1][col], temp[row + 1][col + 1]};
                } else {
                    neighbors = new char[]{temp[row - 1][col - 1], temp[row - 1][col], temp[row - 1][col + 1], temp[row][col - 1],
                            temp[row][col + 1], temp[row + 1][col - 1], temp[row + 1][col], temp[row + 1][col + 1]};
                }
                int liveNeighbors = 0;
                for (char i : neighbors) {
                    if (i == 'O') {
                        liveNeighbors++;
                    }
                }
                if ('O' == temp[row][col]) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        nextGeneration.getUniverse()[row][col] = 'O';
                    } else {
                        nextGeneration.getUniverse()[row][col] = ' ';
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextGeneration.getUniverse()[row][col] = 'O';
                    } else {
                        nextGeneration.getUniverse()[row][col] = ' ';
                    }
                }
            }
        }
        return nextGeneration;
    }
}

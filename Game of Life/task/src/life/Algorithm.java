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
        for (int j = 0; j < temp.length; j++) {
            for (int k = 0; k < temp[j].length; k++) {
                int last = temp.length - 1;
                char nw;
                char n;
                char ne;
                char w;
                char e;
                char se;
                char s;
                char sw;
                if (j == last && k == last) {
                    nw = temp[j - 1][k - 1];
                    n = temp[j - 1][k];
                    ne = temp[j - 1][0];
                    w = temp[j][k - 1];
                    e = temp[j][0];
                    se = temp[0][0];
                    s = temp[0][k];
                    sw = temp[0][k - 1];
                } else if (j == last && k == 0) {
                    nw = temp[j - 1][last];
                    n = temp[j - 1][k];
                    ne = temp[j - 1][k + 1];
                    w = temp[last][last];
                    e = temp[j][k + 1];
                    sw = temp[0][last];
                    s = temp[0][k];
                    se = temp[0][k + 1];
                } else if (j == 0 && k == last) {
                    nw = temp[last][k - 1];
                    n = temp[last][last];
                    ne = temp[last][0];
                    w = temp[j][k - 1];
                    e = temp[j][0];
                    sw = temp[j + 1][k - 1];
                    s = temp[j + 1][k];
                    se = temp[j + 1][0];
                } else if (j == last) {
                    nw = temp[j - 1][k - 1];
                    n = temp[j - 1][k];
                    ne = temp[j - 1][k + 1];
                    w = temp[j][k - 1];
                    e = temp[j][k + 1];
                    sw = temp[0][k - 1];
                    s = temp[0][k];
                    se = temp[0][k + 1];
                } else if (k == last) {
                    nw = temp[j - 1][k - 1];
                    n = temp[j - 1][k];
                    ne = temp[j - 1][0];
                    w = temp[j][k - 1];
                    e = temp[j][0];
                    sw = temp[j + 1][k - 1];
                    s = temp[j + 1][k];
                    se = temp[j + 1][0];
                } else if (j == 0 && k == 0) {
                    nw = temp[last][last];
                    n = temp[last][k];
                    ne = temp[last][k + 1];
                    w = temp[j][last];
                    e = temp[j][k + 1];
                    sw = temp[j + 1][last];
                    s = temp[j + 1][k];
                    se = temp[j + 1][k + 1];
                } else if (j == 0) {
                    nw = temp[last][k - 1];
                    n = temp[last][k];
                    ne = temp[last][k + 1];
                    w = temp[j][k - 1];
                    e = temp[j][k + 1];
                    sw = temp[j + 1][k - 1];
                    s = temp[j + 1][k];
                    se = temp[j + 1][k + 1];
                } else if (k == 0) {
                    nw = temp[j - 1][last];
                    n = temp[j - 1][k];
                    ne = temp[j - 1][k + 1];
                    w = temp[j][last];
                    e = temp[j][k + 1];
                    sw = temp[j + 1][last];
                    s = temp[j + 1][k];
                    se = temp[j + 1][k + 1];
                } else {
                    nw = temp[j - 1][k - 1];
                    n = temp[j - 1][k];
                    ne = temp[j - 1][k + 1];
                    w = temp[j][k - 1];
                    e = temp[j][k + 1];
                    sw = temp[j + 1][k - 1];
                    s = temp[j + 1][k];
                    se = temp[j + 1][k + 1];
                }
                char[] neighbors = {nw, n, ne, w, e, sw, s, se};
                int liveNeighbors = 0;
                for (char i : neighbors) {
                    if (i == 'O') {
                        liveNeighbors++;
                    }
                }
                if ('O' == temp[j][k]) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        nextGeneration.getUniverse()[j][k] = 'O';
                    } else {
                        nextGeneration.getUniverse()[j][k] = ' ';
                    }
                } else {
                    if (liveNeighbors == 3) {
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

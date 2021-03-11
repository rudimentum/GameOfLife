package life;

public class UniverseState {
    private final char[][] universe;

    public UniverseState(char[][] universe) {
        this.universe = universe;
    }

    public char[][] getUniverse() {
        return universe;
    }

    public void print() {
        for (char[] i : universe) {
            for (char j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

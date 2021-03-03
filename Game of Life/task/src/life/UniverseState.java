package life;

public class UniverseState {
    private final String[][] universe;

    public UniverseState(String[][] universe) {
        this.universe = universe;
    }

    public String[][] getGeneration() {
        return universe;
    }

    public void print() {
        for (String[] i : universe) {
            for (String j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

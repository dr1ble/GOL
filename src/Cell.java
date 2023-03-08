import java.io.PrintStream;
import java.util.LinkedList;

public class Cell {

    private LinkedList<Cell> neighbours = new LinkedList<Cell>();
    private State state;

    public void addNeighbour(Cell n) {
        neighbours.add(n);
    }

    public State nextState() {
        int count = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour.isAlive()) {
                count++;
            }
        }
        if (state == State.ALIVE && count == 2) return State.ALIVE;
        if (count == 3) return State.ALIVE;

        return State.DEAD;
    }

    public boolean isAlive() {
        return state == State.ALIVE;
    }

    public void setState(State state) {
        this.state = state;
    }
//    public static int countCell(){
//        int count = 0;
//        for (Cell neighbour : neighbours) {
//            if (neighbour.isAlive()) {
//                count++;
//            }
//        }
//        return count;
//    }
}

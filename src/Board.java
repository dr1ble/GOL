import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

public class Board extends JFrame {
    private final int width;
    private final int height;
    private Cell[] cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width * height];
        for (int i=0; i<cells.length; i++) {
            cells[i] = new Cell();
        }

        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++) {
                Cell cell = getCell(x,y);
                cell.addNeighbour(getCell(x - 1, y + 1));
                cell.addNeighbour(getCell(x, y + 1));
                cell.addNeighbour(getCell(x + 1, y + 1));
                cell.addNeighbour(getCell(x - 1, y));
                cell.addNeighbour(getCell(x + 1, y));
                cell.addNeighbour(getCell(x - 1, y - 1));
                cell.addNeighbour(getCell(x, y - 1));
                cell.addNeighbour(getCell(x+1, y-1));
            }
        }
//        for(int x = 0; x < width; x++){
//            for(int y = 0; y < height; y++){
//                for(int sx = -1; sx <= 1; sx ++){
//                    for(int sy =-1; sy <= 1; sy ++){
//                        if(sx != 0 && sy != 0)
//                            getCell(x,y).addNeighbour(getCell(((x + sx + width) % width),(y + sy + height) % height));
//                    }
//                }
//            }
//        }
    }

    private Cell getCell(int x, int y) {
        if (x < 0 || x >= width) {
            return new NullCell();
        }
        if (y < 0 || y >= height) {
            return new NullCell();
        }
        return cells[x + y*width];
    }

    public Board nextState() {
        Board nextboard = new Board(this.width, this.height);
        for (int i=0; i<cells.length; i++) {
            nextboard.cells[i].setState(this.cells[i].nextState());
        }
        return nextboard;
    }

    public void set(int x, int y) {
        getCell(x, y).setState(State.ALIVE);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void paint(Graphics g2d) {
        g2d.setColor(Color.GRAY);
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++) {
                Cell cell = getCell(x, y);
                if (cell.isAlive()) {
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(x, y, 1, 1);
                }
            }
        }
    }
}

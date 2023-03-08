import java.awt.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class Game {

    private Board board;
    private Ui ui;
    public Game(int width, int height) {
        this.board = new Board(width, height);
        Random random = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (random.nextBoolean()) {
                    board.set(x, y);
                }
            }
        }
        board.set(2, 1);
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        Game game = new Game(width, height);
        Ui ui = new Ui();
        game.setUi(ui);
        while (true) {
            game.tick();
            game.printBoard();
            Thread.sleep(200);
        }
    }

    private void setUi(Ui ui) {
        this.ui = ui;
    }

    void tick() {
        board = board.nextState();
    }

    void printBoard() {
        ui.update(board);
    }
}

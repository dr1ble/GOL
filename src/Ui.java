import javax.swing.*;
public class Ui {
    private Visualize v;
    public Ui() {
        JFrame frame = new JFrame("Game of Life");
        v = new Visualize();
        frame.add(v);
        frame.setBounds(0, 0, 640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
    }

    public void update(Board board) {
        v.update(board);
    }
}

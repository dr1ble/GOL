import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class Visualize extends JPanel {

    private Board board;
    public double xscale, yscale;
    public void update(Board board) {
        this.board = board;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (board == null) {
            return;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        double xscale = (double)getWidth() / board.getWidth();
        double yscale = (double)getHeight() / board.getHeight();
        g2d.setColor(Color.black);
        g2d.scale(xscale, yscale);
        g2d.setColor(Color.BLUE);
        board.paint(g2d);
    }
}

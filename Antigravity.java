import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

// this file is an otamesi program of anti-gravity moving
public class Antigravity {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    public static void main(String[] args) {
        GameWindow gw = new GameWindow("antigravity", WIDTH, HEIGHT);
        gw.add(new DrawCanvas());
        gw.setVisible(true);
    }
}

// window class
class GameWindow extends JFrame {
    // override GameWindow funciton of JFrame
    public GameWindow(String title, int width, int height) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}

// paper to write some graph
class DrawCanvas extends JPanel {
    // override paintComponent function of JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Colors.BLACK);
    }
}
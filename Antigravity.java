import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// this file is an otamesi program of anti-gravity moving
public class Antigravity extends JFrame implements ActionListener {
    // constants
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int FRAME_PER_SECOND = 60;
    public static final String TITLE = "Antigravity";
    public static final int WINDOW_DEPTH = 25;

    // instance variable
    static Antigravity me;
    static Timer timer;
    static Canvas canvas;

    // Constructor
    Antigravity() {
        super(TITLE);

        timer = new Timer(1000 / FRAME_PER_SECOND, this);
        timer.start();

        canvas = new Canvas();
        add(canvas);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // main function
    public static void main(String[] args) {
        me = new Antigravity();

        // assign mouse event
        assignMouseEvent(me);
    }

    // this function is called FRAME_PER_SECOND times per second
    public void actionPerformed(ActionEvent e) {
        canvas.repaint();
    }

    // assign mouse event
    public static void assignMouseEvent(Antigravity antigravity) {
        antigravity.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });

        antigravity.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }
}
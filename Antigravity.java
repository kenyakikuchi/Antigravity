import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;

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
    static Car car;

    // Constructor
    Antigravity() {
        super(TITLE);

        timer = new Timer(1000 / FRAME_PER_SECOND, this);
        timer.start();

        car = new Car();
        add(car);

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
        //car.move(1);
        car.repaint();
    }

    // assign mouse event
    public static void assignMouseEvent(Antigravity antigravity) {
        antigravity.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.printf("mouse entered at (%d, %d)\n", e.getX(), e.getY());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.printf("mouse exited at (%d, %d)\n", e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.printf("mouse clicked at (%d, %d)\n", e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.printf("mouse released at (%d, %d)\n", e.getX(), e.getY());
            }
        });

        antigravity.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //System.out.printf("mouse dragged at (%d, %d)\n", e.getX(), e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //System.out.printf("mouse is at (%d, %d)\n", e.getX(), e.getY());
                car.setLocation((double)e.getX(), (double)e.getY() - WINDOW_DEPTH);
            }
        });
    }
}
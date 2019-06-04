import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.lang.System;

// this file is an otamesi program of anti-gravity moving
public class Antigravity extends JFrame implements ActionListener {
    // constants
    public static final int WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
    public static final int HEIGHT = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
    public static final int FRAME_PER_SECOND = 60;
    public static final String TITLE = "Antigravity";
    public static final int WINDOW_DEPTH = 25;
    public static final int TIMER_COUNT = 1;

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
        //setResizable(false);
        setUndecorated(true);
        setVisible(true);
    }

    // main function
    public static void main(String[] args) {
        me = new Antigravity();

        // assign events
        assignMouseEvent(me);
        assignKeyEvent(me);

        // change fullscreen mode
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(me);
    }

    // this function is called FRAME_PER_SECOND times per second
    public void actionPerformed(ActionEvent e) {
        canvas.update(TIMER_COUNT);
        canvas.repaint();
    }

    // assign key event
    public static void assignKeyEvent(Antigravity antigravity) {
        antigravity.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 0x1b) {
                    System.exit(0);
                }
            }
       });
    }

    // assign mouse event
    public static void assignMouseEvent(Antigravity antigravity) {
        antigravity.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                canvas.setMouseEvent(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                canvas.setMouseEvent(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                canvas.setMouseEvent(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                canvas.setMouseEvent(e);
            }
        });

        antigravity.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                canvas.setMouseEvent(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                canvas.setMouseEvent(e);
            }
        });
    }
}

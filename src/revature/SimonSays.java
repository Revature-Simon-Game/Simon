package revature;

import revature.gui.SimonGui;
import revature.gui.SimonRender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimonSays implements ActionListener, MouseListener{

    public static SimonSays simon;

    public int highScore;

    int colorFlash = 0;

    public final int HEIGHT = 600;
    public final int WIDTH = 600;

    public JFrame frame = new JFrame();

    public JLabel label = new JLabel("High Score: " + highScore);
    public JButton start = new JButton("Start");

    public SimonRender render;

    public SimonSays() {
        Timer timer = new Timer(20,this);

        render = new SimonRender();

        frame.setSize(WIDTH + 6, HEIGHT + 29);
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.setResizable(false);
        frame.add(render);
//        frame.add(blue);
//        frame.add(red);
//        frame.add(green);
//        frame.add(yellow);
//        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer.start();
    }

    public static void main(String[] args) {

        simon = new SimonSays();

        //game.run();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        render.repaint();
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,WIDTH,HEIGHT);

        if (colorFlash == 1)
            g.setColor(Color.GREEN);
        else
            g.setColor(Color.GREEN.darker());

        g.fillArc(0,0,WIDTH, HEIGHT, 90, 90);

        if (colorFlash == 2)
            g.setColor(Color.RED);
        else
            g.setColor(Color.RED.darker());
        g.fillArc(0, 0, WIDTH, HEIGHT, 90, -90);

        if (colorFlash == 3)
            g.setColor(Color.BLUE);
        else
            g.setColor(Color.BLUE.darker());
        g.fillArc(0, 0, WIDTH, HEIGHT, 0, -90);

        if (colorFlash == 4)
            g.setColor(Color.YELLOW);
        else
            g.setColor(Color.YELLOW.darker());
        g.fillArc(0, 0, WIDTH, HEIGHT, 180, 90);

        g.setColor(Color.BLACK);
        g.fillArc(WIDTH / 4, HEIGHT / 4, WIDTH / 2, HEIGHT / 2, 0, 360);
        g.fillRect((WIDTH / 2) - 15, 0, 30, HEIGHT);
        g.fillRect(0, (HEIGHT / 2) - 15, WIDTH, 30);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x + " " + y);
        if (x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2) {
            colorFlash = 1;
        } else if(x > WIDTH / 2 && x < WIDTH && y > 0 && y < HEIGHT / 2) {
            colorFlash = 2;
        } else if(x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 && y < HEIGHT) {
            colorFlash = 4;
        } else if (x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 && y < HEIGHT) {
            colorFlash = 3;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

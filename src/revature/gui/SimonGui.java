package revature.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimonGui implements ActionListener {

    public int highScore = 0;

    public final int HEIGHT = 600;
    public final int WIDTH = 600;

    JFrame frame = new JFrame();

    JLabel  label  = new JLabel("High Score: " + highScore);
    JButton start  = new JButton("Start");
    JButton red    = new JButton("red");
    JButton green  = new JButton("green");
    JButton blue   = new JButton("blue");
    JButton yellow = new JButton("yellow");

    public SimonGui() {
        label.setBounds(200,0, 100,100);

        start.setBounds(0,0,100,30);

//        blue.setBounds(300,100,200,200);
//        blue.setBackground(Color.BLUE);
//
//        green.setBounds(100,100,200,200);
//        green.setBackground(Color.GREEN);
//
//        red.setBounds(300,300,200,200);
//        red.setBackground(Color.RED);
//
//        yellow.setBounds(100,300,200,200);
//        yellow.setBackground(Color.YELLOW);

        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(null);
        frame.add(start);
//        frame.add(blue);
//        frame.add(red);
//        frame.add(green);
//        frame.add(yellow);
//        frame.add(label);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
    

    public void paint(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0, WIDTH, HEIGHT);
        

        g.setColor(Color.GREEN);
        g.fillRect(0,0, WIDTH / 2, HEIGHT / 2);
        g.setColor(Color.RED);
        g.fillRect(WIDTH / 2,0, WIDTH / 2, HEIGHT / 2);
        g.setColor(Color.YELLOW);
        g.fillRect(0,HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
        g.setColor(Color.BLUE);
        g.fillRect(WIDTH / 2,HEIGHT / 2, WIDTH / 2, HEIGHT / 2);



    }
}

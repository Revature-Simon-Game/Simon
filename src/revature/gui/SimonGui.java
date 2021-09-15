package revature.gui;

import javafx.scene.effect.ColorInputBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimonGui implements MouseListener {

    public int highScore;

    public final int HEIGHT = 600;
    public final int WIDTH = 600;

    JFrame frame = new JFrame();

    JLabel label = new JLabel("High Score: " + highScore);
    JButton start = new JButton("Start");
    JButton blue = new JButton("blue");
    JButton green = new JButton("green");
    JButton red = new JButton("red");
    JButton yellow = new JButton("yellow");

    public SimonGui() {
        label.setBounds(200,0, 100,100);

        start.setBounds(0,0,100,30);

        blue.setBounds(300,100,200,200);
        blue.setBackground(Color.BLUE);

        green.setBounds(100,100,200,200);
        green.setBackground(Color.GREEN);

        red.setBounds(300,300,200,200);
        red.setBackground(Color.RED);

        yellow.setBounds(100,300,200,200);
        yellow.setBackground(Color.YELLOW);

        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(null);
        frame.add(start);
        frame.add(blue);
        frame.add(red);
        frame.add(green);
        frame.add(yellow);
        frame.add(label);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    public void run() {
//        Scanner user = new Scanner(System.in);
//        List<Integer> pattern = new ArrayList();
//        boolean loss = false;
//        Random rand = new Random();
//        int input = 0;
//
//        System.out.println("Simon says with a number between 1-4");
//
//        while (!loss) {
//            pattern.add(rand.nextInt((4-1) + 1) + 1);
//            System.out.println(pattern);
//            for (int i : pattern) {
//                if (loss) {
//                    System.out.println("1st loss");
//                    break;
//                }
//
//                if (user.hasNextInt()) {
//                    input = user.nextInt();
//                }
//                else {
//                    loss = true;
//                }
//
//                if (input != i) {
//                    loss = true;
//                    System.out.println("2nd loss" + input + " " + i);
//                    break;
//                }
//            }
//            if(loss) {
//                System.out.println("You lose! Your record is " + pattern.size());
//            }
//        }
    }
}

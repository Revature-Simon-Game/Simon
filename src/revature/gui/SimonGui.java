package revature.gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimonGui {

    public final int HEIGHT = 600;
    public final int WIDTH = 600;

    public SimonGui() {
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

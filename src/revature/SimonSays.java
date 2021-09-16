package revature;

import revature.gui.ColorFlash;
import revature.gui.SimonRender;

import revature.GamePlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimonSays implements ActionListener, MouseListener{

    public static SimonSays simon;
    
    public GamePlay gamePlay = new GamePlay();

    public int highScore;

    ColorFlash colorFlash = ColorFlash.NONE;

    public final int HEIGHT = 600;
    public final int WIDTH = 600;

    public JFrame frame = new JFrame("Simon Says");
    Timer timer = new Timer(100, this);

    public JLabel label = new JLabel("High Score: " + highScore);
    public JButton start = new JButton("Start");

    public SimonRender render;

    public SimonSays() {
        render = new SimonRender();
        
        start.setBounds(30,30,0,0);
        
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
    
    public Color darken(Color color) {
        return color.darker().darker().darker();
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,WIDTH,HEIGHT);

        if (colorFlash == ColorFlash.GREEN) {
            g.setColor(Color.GREEN);
            System.out.println(gamePlay.patternCheck(colorFlash));
            timer.start();
            colorFlash = ColorFlash.NONE;
			System.out.println(gamePlay.pattern);
        } else {
            g.setColor(darken(Color.GREEN));
        }

        g.fillArc(0,0,WIDTH, HEIGHT, 90, 90);

        if (colorFlash == ColorFlash.RED) {
            g.setColor(Color.RED);
            System.out.println(gamePlay.patternCheck(colorFlash));
            timer.start();
            colorFlash = ColorFlash.NONE;
			System.out.println(gamePlay.pattern);
        } else {
            g.setColor(darken(Color.RED));
        }
        
        g.fillArc(0, 0, WIDTH, HEIGHT, 90, -90);

        if (colorFlash == ColorFlash.BLUE) {
            g.setColor(Color.BLUE);
            System.out.println(gamePlay.patternCheck(colorFlash));
            timer.start();
            colorFlash = ColorFlash.NONE;
			System.out.println(gamePlay.pattern);
        } else
            g.setColor(darken(Color.BLUE));
        
        g.fillArc(0, 0, WIDTH, HEIGHT, 0, -90);

        if (colorFlash == ColorFlash.YELLOW) {
            g.setColor(Color.YELLOW);
            System.out.println(gamePlay.patternCheck(colorFlash));
            timer.start();
            colorFlash = ColorFlash.NONE;
			System.out.println(gamePlay.pattern);
        } else {
            g.setColor(darken(Color.YELLOW));
        }
        
        g.fillArc(0, 0, WIDTH, HEIGHT, 180, 90);

        g.setColor(Color.BLACK);
        g.fillArc(WIDTH / 4, HEIGHT / 4, WIDTH / 2, HEIGHT / 2, 0, 360);
        g.fillRect((WIDTH / 2) - 15, 0, 30, HEIGHT);
        g.fillRect(0, (HEIGHT / 2) - 15, WIDTH, 30);
        
        g.setColor(Color.GRAY);
        g.drawArc((WIDTH / 4)+20, (HEIGHT / 4)+20, (WIDTH/2)-40, (HEIGHT / 2)-40, 0, 360);
        g.fillArc((WIDTH / 4)+20, (HEIGHT / 4)+20, (WIDTH/2)-40, (HEIGHT / 2)-40, 180, 180);

        g.setFont(new Font("Purisa", Font.BOLD, 45));
        g.drawString("SIMON", (WIDTH/2)-65,(HEIGHT/2)-40);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	int x = e.getX();
        int y = e.getY();
        System.out.println(x + " " + y);
        if (x > 200 && x < 400 && y > 230 && y < 420) {
        	gamePlay.pattern.clear();
			gamePlay.increment();
			gamePlay.increment();
			timer.setDelay(1000);
			for (int i : gamePlay.pattern) {
				if(i == 1) {
					colorFlash = ColorFlash.GREEN;
					timer.start();
				}

				if(i == 2) {
					colorFlash = ColorFlash.RED;
					timer.start();
				}

				if(i == 3) {
					colorFlash = ColorFlash.BLUE;
					timer.start();
				}

				if(i == 4) {
					colorFlash = ColorFlash.YELLOW;
					timer.start();
				}
			}
			timer.setDelay(100);
        }
        else if (x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2 + 30) {
            colorFlash = ColorFlash.GREEN;
        } else if(x > WIDTH / 2 && x < WIDTH && y > 0 && y < HEIGHT / 2 + 30) {
            colorFlash = ColorFlash.RED;
        } else if(x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 + 30 && y < HEIGHT) {
            colorFlash = ColorFlash.YELLOW;
        } else if (x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 + 30 && y < HEIGHT) {
            colorFlash = ColorFlash.BLUE;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
}

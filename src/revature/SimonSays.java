package revature;

import revature.gui.ColorFlash;
import revature.gui.SimonRender;
import revature.sound.Sfx;
import revature.sound.SoundTypes;
import revature.GamePlay;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimonSays implements ActionListener, MouseListener{

    public static SimonSays simon;
    
    public Sfx sfx = new Sfx();
    
    public GamePlay gamePlay = new GamePlay();

    public int highScore;
    public boolean pattern = false;
    public int patternCount = 1;

    ColorFlash colorFlash = ColorFlash.NONE;

    public final int HEIGHT = 600;
    public final int WIDTH = 600;

    public JFrame frame = new JFrame("Simon Says");
    Timer timer = new Timer(50, this);
    int clockTimer;

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
    	clockTimer++;

        if (clockTimer % 10 == 0) {
	    	colorFlash = ColorFlash.NONE;
	    	if (pattern && patternCount <= gamePlay.pattern.size() - 1) {
	    		colorFlash = color(gamePlay.pattern.get(patternCount));
	    		patternCount++;
	        }
	    	else {
    			patternCount = 0;
    			pattern = false;
    		}
        }

        render.repaint();
    }

    public ColorFlash color(int num) {
        switch (num) {
            case 1:
                return ColorFlash.GREEN;
            case 2:
                return ColorFlash.RED;
            case 3:
                return ColorFlash.BLUE;
            case 4:
                return ColorFlash.YELLOW;
        }
        return ColorFlash.NONE;
    }

    public Color darken(Color color) {
        return color.darker().darker().darker();
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,WIDTH,HEIGHT);

        if (colorFlash == ColorFlash.GREEN) {
            sfx(SoundTypes.GREEN);
            g.setColor(Color.GREEN);
            if (pattern == false) {
	            if(!gamePlay.patternCheck(colorFlash)) {
	            	sfx(SoundTypes.LOSS);
	            };
	            colorFlash = ColorFlash.NONE;
				System.out.println(gamePlay.pattern);
				if (gamePlay.patternPlace == gamePlay.pattern.size() && gamePlay.patternPlace > 0) {
					pattern = true;
					gamePlay.patternPlace = 0;
					gamePlay.increment();
				}
            }
        } else {
            g.setColor(darken(Color.GREEN));
        }

        g.fillArc(0,0,WIDTH, HEIGHT, 90, 90);

        if (colorFlash == ColorFlash.RED) {
            sfx(SoundTypes.RED);
            g.setColor(Color.RED);
            if (pattern == false) {
            	if(!gamePlay.patternCheck(colorFlash)) {
	            	sfx(SoundTypes.LOSS);
	            };
	            colorFlash = ColorFlash.NONE;
				System.out.println(gamePlay.pattern);
				if (gamePlay.patternPlace == gamePlay.pattern.size() && gamePlay.patternPlace > 0) {
					pattern = true;
					gamePlay.patternPlace = 0;
					gamePlay.increment();
				}
            }
        } else {
            g.setColor(darken(Color.RED));
        }
        
        g.fillArc(0, 0, WIDTH, HEIGHT, 90, -90);

        if (colorFlash == ColorFlash.BLUE) {
            sfx(SoundTypes.BLUE);
            g.setColor(Color.BLUE);
            if (pattern == false) {if(!gamePlay.patternCheck(colorFlash)) {
            	sfx(SoundTypes.LOSS);
            };
	            colorFlash = ColorFlash.NONE;
				System.out.println(gamePlay.pattern);
				if (gamePlay.patternPlace == gamePlay.pattern.size() && gamePlay.patternPlace > 0) {
					pattern = true;
					gamePlay.patternPlace = 0;
					gamePlay.increment();
				}
            }
        } else
            g.setColor(darken(Color.BLUE));
        
        g.fillArc(0, 0, WIDTH, HEIGHT, 0, -90);

        if (colorFlash == ColorFlash.YELLOW) {
            sfx(SoundTypes.YELLOW);
            g.setColor(Color.YELLOW);
            if (pattern == false) {
            	if(!gamePlay.patternCheck(colorFlash)) {
	            	sfx(SoundTypes.LOSS);
	            };
	            colorFlash = ColorFlash.NONE;
				System.out.println(gamePlay.pattern);
				if (gamePlay.patternPlace == gamePlay.pattern.size() && gamePlay.patternPlace > 0) {
					pattern = true;
					gamePlay.patternPlace = 0;
					gamePlay.increment();
					System.out.println("Pattern Time");
				}
            }
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
				pattern = true;
				System.out.println(gamePlay.pattern);
	        }
	        else if (x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2 + 30) {
	                colorFlash = ColorFlash.GREEN;
	                clockTimer = 1;
            } else if (x > WIDTH / 2 && x < WIDTH && y > 0 && y < HEIGHT / 2 + 30) {
                colorFlash = ColorFlash.RED;
                clockTimer = 1;
            } else if (x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 + 30 && y < HEIGHT) {
                colorFlash = ColorFlash.YELLOW;
                clockTimer = 1;
            } else if (x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 + 30 && y < HEIGHT) {
                colorFlash = ColorFlash.BLUE;
                clockTimer = 1;
            }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
    public void sfx(SoundTypes sound) {
    	AudioInputStream ai = null;
    	Clip c = null;
		try {switch (sound) {
		case GREEN: {
			ai = AudioSystem.getAudioInputStream(new File("sounds/btn1.wav"));
			break;
		}
		case RED: {
			ai = AudioSystem.getAudioInputStream(new File("sounds/btn2.wav"));
			break;
		}
		case BLUE: {
			ai = AudioSystem.getAudioInputStream(new File("sounds/btn3.wav"));
			break;
		}
		case YELLOW: {
			ai = AudioSystem.getAudioInputStream(new File("sounds/btn4.wav"));
			break;
		}
		case LOSS: {
			ai = AudioSystem.getAudioInputStream(new File("sounds/lose.wav"));
			break;
		}
	}
			c = AudioSystem.getClip();
			c.open(ai);
			
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		c.start();
    	
    }
    
}

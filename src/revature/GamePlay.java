package revature;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import revature.gui.ColorFlash;

import java.awt.*;

public class GamePlay {
		private Random rand = new Random();
		
    	public List<Integer> pattern = new ArrayList();
    	//1234, Green, Red, Blue, Yellow
        int patternPlace = 0;
        
		public GamePlay() {
			super();
		}
        
		public void increment() {
			pattern.add(rand.nextInt((4-1) + 1) + 1);
		}
		
		public boolean patternCheck(ColorFlash colorFlash) {
			System.out.println(pattern);
			System.out.println(patternPlace);
			int patternInput = 0;
			if (pattern.isEmpty()) {
				return false;
			}
			if (colorFlash == ColorFlash.GREEN) {
				patternInput = 1;
			}

			if (colorFlash == ColorFlash.RED) {
	        	patternInput = 2;
	        }

	        if (colorFlash == ColorFlash.BLUE) {
	        	patternInput = 3;
	        }

	        if (colorFlash == ColorFlash.YELLOW) {
	        	patternInput = 4;
	        }
	        
			if(patternInput == pattern.get(patternPlace)) {
				patternPlace++;
				return true;
			}
			else {
				patternPlace = 0;
				pattern.clear();
				pattern.add(rand.nextInt((4-1) + 1) + 1);
				return false;
			}
		}
		
		public void start(Graphics2D g, Timer timer) {
			pattern.clear();
			pattern.add(rand.nextInt((4-1) + 1) + 1);
			timer.setDelay(1000);
			for (int i : pattern) {
				if(i == 1) {
					g.setColor(Color.GREEN);
					timer.start();
					g.setColor(Color.GREEN.darker().darker().darker());
					
					g.fillArc(0,0,600, 600, 90, 90); //Green
				}
				
				if(i == 2) {
					g.setColor(Color.RED);
					timer.start();
					g.setColor(Color.RED.darker().darker().darker());
					
					g.fillArc(0, 0, 600, 600, 90, -90); //Red
				}
				
				if(i == 3) {
					g.setColor(Color.BLUE);
					timer.start();
					g.setColor(Color.BLUE.darker().darker().darker());
					
					g.fillArc(0, 0, 600, 600, 0, -90); //Blue
				}
				
				if(i == 4) {
					g.setColor(Color.YELLOW);
					timer.start();
					g.setColor(Color.YELLOW.darker().darker().darker());
					
					g.fillArc(0, 0, 600, 600, 180, 90); //Yellow
				}
			}
			timer.setDelay(100);
	        
		}
}

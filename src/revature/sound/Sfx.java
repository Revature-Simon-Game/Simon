package revature.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Sfx {
	
	private static boolean initialized = false;
	
	private static Clip red;
	private static Clip green;
	private static Clip blue;
	private static Clip yellow;
	private static Clip loss;
	/* |  ||
	 * || |_
	 */
	
	public static void play(SoundTypes sound)  {
		
		if (!initialized) {
			init();
		}
		
		switch (sound) {
			case RED: {
				resetClip(red);
				red.start();
				break;
			}
			case GREEN: {
				resetClip(green);
				green.start();
				break;
			}
			case BLUE: {
				resetClip(blue);
				blue.start();
				break;
			}
			case YELLOW: {
				resetClip(yellow);
				yellow.start();
				break;
			}
			case LOSS: {
				resetClip(loss);
				loss.start();
				break;
			}
		}
	}
	
	private static void init() {
		red = loadSound("sounds/btn1.wav");
		green = loadSound("sounds/btn2.wav");
		blue = loadSound("sounds/btn3.wav");
		yellow = loadSound("sounds/btn4.wav");
		loss = loadSound("sounds/lose.wav");
		
		initialized = true;
	}
	
	private static Clip loadSound(String path) {
		
		Clip clip = null;
		
		try {
			clip = AudioSystem.getClip(null);
			
			AudioInputStream ai;
			
			ai = AudioSystem.getAudioInputStream((new File(path)));
			clip.open(ai);
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not load sound files.");
			System.out.print("Path to directory: " + (new File(path)).toPath().toAbsolutePath().toString());
			
			System.exit(1);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.out.println();
			e.printStackTrace();
		}
	
		return clip;
	}
	
	private static void resetClip(Clip clip) {
		clip.stop();
		clip.setMicrosecondPosition(0);
	}
}

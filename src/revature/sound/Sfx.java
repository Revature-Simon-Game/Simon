package revature.sound;

import javax.sound.sampled.*;
import java.io.File;
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
	
	private static void init() {
		try {
			red = AudioSystem.getClip();
			green = AudioSystem.getClip();
			blue = AudioSystem.getClip();
			yellow = AudioSystem.getClip();
			loss = AudioSystem.getClip();
			
			AudioInputStream ai;
						
			ai = AudioSystem.getAudioInputStream(new File("../../sounds/btn1.wav"));
			red.open(ai);
			ai = AudioSystem.getAudioInputStream(new File("../../sounds/btn2.wav"));
			green.open(ai);
			ai = AudioSystem.getAudioInputStream(new File("../../sounds/btn3.wav"));
			blue.open(ai);
			ai = AudioSystem.getAudioInputStream(new File("../../sounds/btn4.wav"));
			yellow.open(ai);
			ai = AudioSystem.getAudioInputStream(new File("../../sounds/loss.wav"));
			loss.open(ai);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
	public static void play(SoundTypes sound)  {
		
		if (!initialized) {
			init();
		}
		
		switch (sound) {
			case RED: {
				red.start();
				break;
			}
			case BLUE: {
				blue.start();
				break;
			}
			case YELLOW: {
				yellow.start();
				break;
			}
			case LOSS: {
				loss.start();
				break;
			}
		}
		
		return;
	}
}
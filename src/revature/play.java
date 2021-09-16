package revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class play {
		private Random rand = new Random();
    	public List<Integer> pattern = new ArrayList();
        int patternPlace = 0;
        
		public play() {
			super();
		}
        
		public void increment() {
	        pattern.add(rand.nextInt((4-1) + 1) + 1);
		}
		
		public boolean patternCheck(int patternInput) {
			if(patternInput == pattern.get(patternPlace)) {
				pattern.add(rand.nextInt((4-1) + 1) + 1);
				patternPlace++;
				return true;
			}
			else {
				pattern.clear();
				pattern.add(rand.nextInt((4-1) + 1) + 1);
				return false;
			}
		}
}

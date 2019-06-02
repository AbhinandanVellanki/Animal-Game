import java.util.*;

/**
 * @author abhin This is a Canine class which is a type of Animal, having unique
 *         move and attack rules
 */
public abstract class Canine extends Animal {
	/**
	 * @param r  stores the row position of the Canine object
	 * @param c  stores the column position of the Canine
	 * @param ch stores the column position of the Canine
	 */
	public Canine(int r, int c, char ch) {
		super(r, c, ch);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Animal#move()
	 */
	protected int[] move() {
		int[] posc = this.getpos();
		int r;
		int co;
		int ri = -1;
		int ci = -1;
		int rj = -1;
		int cj = -1;
		do {
			r = posc[0];
			co = posc[1];
			ri = -1;
			ci = -1;
			Random rand = new Random();
			int rant = rand.nextInt(8);
			switch (rant) {
			case 1: {
				r++;
				break;
			}
			case 3: {
				r--;
				break;
			}
			case 0: {
				co++;
				break;
			}
			case 2: {
				co--;
				break;
			}
			case 4: {
				ri = posc[0]++;
				r += 2;				
				break;
			}
			case 5: {
				ri = posc[0]--;
				r -= 2;				
				break;
			}
			case 6: {
				ci = posc[1]++;
				co += 2;				
				break;
			}
			case 7: {
				ci = posc[1]--;
				co -= 2;
				break;
			}
			default: {
				break;
			}
			}
		} while (r > 14 || r < 0 || co > 14 || co < 0);
		int[] newpos = { r, co, ri, ci, rj, cj };
		return newpos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Animal#attack(Animal)
	 */
	protected boolean attack(Animal a) {
		char ch = a.getid();
		if (ch == 'c' || ch == 'l' || ch == 't') {
			Random rand = new Random();
			int rant = rand.nextInt(2);
			switch (rant) {
			case 1: {
				return true;
			}
			case 0: {
				return false;
			}
			default:
				return false;
			}
		}
		if (ch == this.getid()) {
			Random rand = new Random();
			int rant = rand.nextInt(2);
			switch (rant) {
			case 1: {
				return true;
			}
			case 0: {
				return false;
			}
			default:
				return false;
			}
		}
		if (ch == 'u') {
			Random ra = new Random();
			int ran = ra.nextInt(5);
			switch (ran) {
			case 1: {
				return true;
			}
			case 2: {
				return false;

			}
			case 3: {
				return false;

			}
			case 4: {
				return false;

			}
			case 0: {
				return false;

			}
			default:
				return false;
			}
		} else
			return false;
	}
}
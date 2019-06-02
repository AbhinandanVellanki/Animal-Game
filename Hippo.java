import java.util.Random;

/**
 * @author abhin
 * This is a Hippo Class which is a type of animal
 */
public class Hippo extends Animal {
	/**
	 * @param r is the row position of the Hippo object
	 * @param c is the column position of the Hippo object
	 * @param ch is the id of the Hippo object
	 * This is a parameterized constructor
	 */
	public Hippo(int r, int c, char ch) {
		super(r, c, ch);
	}

	/* (non-Javadoc)
	 * @see Animal#move()
	 */
	protected int[] move() {
		int[] posh = this.getpos();
		int r;
		int co;
		int ri=-1;
		int ci=-1;
		do {
			r = posh[0];
			co = posh[1];
			Random rand = new Random();
			int rant = rand.nextInt(4);
			switch (rant) {
			case 0: {
				r++;
				break;
			}
			case 1: {
				r--;
				break;
			}
			case 2: {
				co++;
				break;
			}
			case 3: {
				co--;
				break;
			}
			default: {
				break;
			}
			}
		} while (r > 14 || r < 0 || co > 14 || co < 0);
		int[] newpos = { r, co, ri, ci };
		return newpos;
	}

	/* (non-Javadoc)
	 * @see Animal#attack(Animal)
	 */
	protected boolean attack(Animal a) {
		char ch = a.getid();
		if (ch == 'h') {
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
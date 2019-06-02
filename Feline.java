import java.util.Random;

/**
 * @author abhin
 * This is a Feline class which is a type of Animal, having its own movement and attack rules
 */
public abstract class Feline extends Animal {
	/**
	 * @param r stores the row position of the Feline object
	 * @param c stores the column position of the Feline
	 * @param ch stores the column position of the Feline
	 */
	public Feline(int r, int c, char ch) {
		super(r, c, ch);
	}

	/* (non-Javadoc)
	 * @see Animal#move()
	 */
	protected int[] move() {
		int[] posf = this.getpos();
		int r;
		int co;
		int ri=-1;
		int ci=-1;
		int rj=-1;
		int cj=-1;
		do {
			r = posf[0];
			co = posf[1];
			Random rand = new Random();
			int rant = rand.nextInt(8);
			switch (rant) {
			case 1: {
				r++;
				break;
			}
			case 2: {
				r++;
				co++;
				break;
			}
			case 3: {
				r--;
				break;
			}
			case 4: {
				r--;
				co++;
				break;
			}
			case 5: {
				co++;
				break;
			}
			case 6: {
				co--;
				r++;
				break;
			}
			case 7: {
				co--;
				break;
			}
			case 0: {
				co--;
				r--;
				break;
			}
			default: {
				break;
			}
			}
		}while (r > 14 || r < 0 || co > 14 || co < 0);
		int[] newpos = { r, co, ri, ci, rj, cj };
		return newpos;
	}

	/* (non-Javadoc)
	 * @see Animal#attack(Animal)
	 */
	protected boolean attack(Animal a) {
		char ch = a.getid();
		if (ch == 'd' || ch == 'f' || ch == 'w') {
			return true;
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
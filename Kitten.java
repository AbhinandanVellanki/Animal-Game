import java.util.Random;

/**
 * @author abhin This is a Kitten Class which is a type of Cat
 */
public class Kitten extends Animal {
	/**
	 * @param r  is the row position of the Kitten object
	 * @param c  is the column position of the Kitten object
	 * @param ch is the id of the Kitten object This is a parameterized constructor
	 */
	public Kitten(int r, int c, char ch) {
		super(r, c, ch);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Animal#move()
	 */
	protected int[] move() {
		int[] posh = this.getpos();
		int r;
		int co;
		int ri = -1;
		int ci = -1;
		do {
			r = posh[0];
			co = posh[1];
			Random rand = new Random();
			int rant = rand.nextInt(10);
			if (rant == 0 || rant == 1 || rant == 2) {
				r = posh[0];
				co = posh[1];
			} else {
				int ran = rand.nextInt(8);
				switch (ran) {
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
			}
		} while (r > 14 || r < 0 || co > 14 || co < 0);
		int[] newpos = { r, co, ri, ci };
		return newpos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Animal#attack(Animal)
	 */
	protected boolean attack(Animal a) {
		char ch = a.getid();
		if (ch != 'c' && ch != this.getid()) {
			return false;
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
		if (ch == 'c') {
			Random ra = new Random();
			int ran = ra.nextInt(10);
			switch (ran) {
			case 0: {
				return true;
			}
			case 1: {
				return true;
			}
			case 2: {
				return true;
			}
			case 3: {
				return false;
			}
			case 4: {
				return false;
			}
			case 5: {
				return false;
			}
			case 6: {
				return false;
			}
			case 7: {
				return false;
			}
			case 8: {
				return false;
			}
			case 9: {
				return false;
			}
			default:
				return false;
			}
		} else
			return false;
	}

}
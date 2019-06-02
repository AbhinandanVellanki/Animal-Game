import java.util.*;

/**
 * @author abhin This class Turtle is a type of animal that has its own unique
 *         rules for moving and attacking other animals
 */
class Turtle extends Animal {
	/**
	 * @param r  contains row position of the turtle
	 * @param c  contains column position of the turtle
	 * @param ch contains id of the turtle, always 't' This is a parameterized
	 *           constructor
	 */
	public Turtle(int r, int c, char ch) {
		super(r, c, ch);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Animal#move()
	 */
	protected int[] move() {
		int[] post = this.getpos();
		int r;
		int co;
		int ri = -1;
		int ci = -1;
		int rj = -1;
		int cj = -1;
		do {
			r = post[0];
			co = post[1];
			Random rand = new Random();
			int rant = rand.nextInt(8);
			switch (rant) {
			case 1: {
				r++;
				break;
			}
			case 2: {
				break;
			}
			case 3: {
				r--;
				break;
			}
			case 4: {
				break;
			}
			case 5: {
				co++;
				break;
			}
			case 6: {
				co--;
				break;
			}
			case 7: {
				break;
			}
			case 0: {
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
}
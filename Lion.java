import java.util.*;

/**
 * @author abhin
 * This is a Lion class which is a type of Feline which is a type of Animal
 */
public class Lion extends Feline {
	/**
	 * @param r is the row position of the Lion object
	 * @param c is the column position of the Lion object
	 * @param ch is the id of the Lion object
	 * This is a parameterized constructor
	 */
	public Lion(int r, int c, char ch) {
		super(r, c, ch);
	}

	/* (non-Javadoc)
	 * @see Feline#attack(Animal)
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
		}
		if (ch == 'h')
			return true;
		else
			return false;
	}

}

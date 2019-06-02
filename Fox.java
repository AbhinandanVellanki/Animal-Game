import java.util.Random;

/**
 * @author abhin
 * This is a Fox class which is a type of Canine which is a type of Animal
 */
class Fox extends Canine {
	/**
	 * @param r is the row position of the Fox object
	 * @param c is the column position of the Fox object
	 * @param ch is the id of the Fox object
	 * This is a parameterized constructor
	 */
	public Fox(int r, int c, char ch) {
		super(r, c, ch);
	}

	/* (non-Javadoc)
	 * @see Canine#attack(Animal)
	 */
	protected boolean attack(Animal a) {
		char ch = a.getid();
		if (ch == 'l' || ch == 't') {
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
				return false;
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
			case 0: {
				return false;

			}
			default:
				return false;
			}
		}
		if (ch == 'c')
			return true;
		else
			return false;
	}
}
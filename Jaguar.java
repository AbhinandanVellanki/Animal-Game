import java.util.Random;

/**
 * @author abhin This is a Jaguar class which is a type of Feline which is a
 *         type of Animal
 */
public class Jaguar extends Feline {
	/**
	 * @param r  is the row position of the Jaguar object
	 * @param c  is the column position of the Jaguar object
	 * @param ch is the id of the Jaguar object This is a parameterized constructor
	 */
	public Jaguar(int r, int c, char ch) {
		super(r, c, ch);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Feline#attack(Animal)
	 */
	protected boolean attack(Animal a) {
		char ch = a.getid();
		if (ch == 'd' || ch == 'f' || ch == 'w') {// attacks canine
			return true;
		}
		if (ch == this.getid()) {// attacks jaguar
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
			return true;
		} else
			return false;
	}

}

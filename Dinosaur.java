import java.util.Random;

/**
 * @author abhin This is a Dinosaur Class which is a type of animal
 */
public class Dinosaur extends Animal {
	/**
	 * @param r  is the row position of the Dinaosaur object
	 * @param c  is the column position of the Dinosaur object
	 * @param ch is the id of the Dinosaur object This is a parameterized
	 *           constructor
	 */
	public Dinosaur(int r, int c, char ch) {
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
		int r1 = -1;
		int co1 = -1;
		int r2 = -1;
		int co2 = -1;
		do {
			r = posh[0];
			co = posh[1];
			r1 = co1 = r2 = co2 = -1;
			Random rand = new Random();
			int rant = rand.nextInt(4);
			switch (rant) {
			case 0: {
				r1++;
				r2 += 2;
				r += 3;
				
				break;
			}
			case 1: {
				r -= 3;
				r1--;
				r2 -= 2;
				
				break;
			}
			case 2: {
				co += 3;
				co1++;
				co2 += 2;
				
				break;
			}
			case 3: {
				co -= 3;
				co1--;
				co2 -= 2;
				
				break;
			}
			default: {
				break;
			}
			}
		} while (r > 14 || r < 0 || co > 14 || co < 0);
		int[] newpos = { r, co, r2, co2, r1, co1 };
		return newpos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Animal#attack(Animal)
	 */
	protected boolean attack(Animal a) {
		char ch = a.getid();
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
		} else
			return true;
	}

}
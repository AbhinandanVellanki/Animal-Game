/**
 * @author abhin This is a superclass Animal from which all animals are
 *         extended. It defines the basic parameters of the Animal objects and
 *         provides abstract methods to describe the functionality
 */
public abstract class Animal implements Comparable<Animal> {
	private int rp;
	private int cp;
	private char id;

	/**
	 * @param r parameter that stores the row position of the animal object
	 * @param c parameter that stores the column position of the animal object
	 * @param i parameter that stores the id of the animal object which is the
	 *          character that represents the type of the animal This is a
	 *          parameterized constructor that initializes the instance variables to
	 *          the values passed as parameters during initialization
	 */
	public Animal(int r, int c, char i) {
		rp = r;
		cp = c;
		id = i;
	}

	/**
	 * @return returns an array containing the row and column positions of the
	 *         animal
	 */
	protected int[] getpos() {
		int[] pos = { rp, cp };
		return pos;
	}

	/**
	 * @param ro contains the new row position that the animal has been moved to
	 * @param co contains the new column position that the animal has been moved to
	 */
	protected void update(int ro, int co) {
		rp = ro;
		cp = co;
	}

	/**
	 * @return returns the id of the currently calling animal object
	 */
	protected char getid() {
		return id;
	}

	/**
	 * @return returns an array containing the new row and column positions that the
	 *         animal has been moved to
	 */
	abstract int[] move();

	/**
	 * @param a is an animal object that the currently calling object attacks
	 * @return returns the result of the attack in boolean This method is called
	 *         from an animal object whenever an attack is to be made
	 */
	abstract boolean attack(Animal a);

	/**
	 * @param a is the animal object that the currently calling object must be
	 *          checked against
	 * @return returns the result of the comparison between the two animal objects
	 *         This method is called from an animal object whenever a comparison is
	 *         to be made
	 */
	protected boolean equals(Animal a) {
		if (a.getid() == this.getid() && a.getpos() == this.getpos()) {
			return true;
		} else
			return false;
	}

	// @override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Animal a) {
		String a1id = Character.toString(a.getid());
		String a2id = Character.toString(this.id);
		return a2id.compareTo(a1id);
	}
}

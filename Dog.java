/**
 * @author abhin
 * This class Dog is a type of Canine which is a type of Animal. It has the same movement and attack rules as Canine
 */
class Dog extends Canine {
	/**
	 * @param r is the row position of the Dog
	 * @param c is the column position of the Dog 
	 * @param ch is the id of the Dog, always 'd'
	 * This is a parameterized constructor 
	 */
	public Dog(int r, int c, char ch) {
		super(r, c, ch);
	}

}
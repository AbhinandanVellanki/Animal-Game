/**
 * @author abhin
 * This is the board class used to disply the positions of the animals in a 2D grid
 */
class Board {
	private char B[][] = new char[15][15];

	/**
	 * Default constructor, initializes every element to '.'
	 */
	Board() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				B[i][j] = '.';
			}
		}
	}

	/**
	 * Displays the current state of the board
	 */
	void display() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(B[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * @param r row index of position to be updated
	 * @param c column index of position to be updated
	 * @param ch id with which the position must be updated
	 */
	void update(int r, int c, char ch) {
		if (r <= 14 && r >= 0 && c <= 14 && c >= 0)
			B[r][c] = ch;
		else {
			System.out.println("Animal moved to invalid location, program will terminate");
			System.exit(1);
		}
	}

	/**
	 * @param r row index of position to be checked
	 * @param c column index of position to be checked
	 * @return returns boolean after checking whether the position stores a character other than '.'  
	 */
	boolean occupied(int r, int c) {
		if (B[r][c] != '.')
			return true;
		else
			return false;
	}

	/**
	 * @param r row index of position to be deleted
	 * @param c column index of position to be deleted
	 */
	void delete(int r, int c) {
		B[r][c] = '.';
	}
}
import java.util.*;

/**
 * @author abhin
 * This is a program that implements a forest which has 8 different kinds of animals with unique movement patterns and attack rules
 */
class Forest {
	private static ArrayList<Animal> For = new ArrayList<Animal>();
	private static ArrayList<Animal> dead = new ArrayList<Animal>();
	private static Board bd = new Board();

	public static void main(String args[]) {

		Forest obj = new Forest();
		obj.run();
	}

	/**
	 * This is the block that handles continuous execution after input is done
	 */
	private void execute() {
		Scanner scr = new Scanner(System.in);
		String s = "";
		do {
			System.out.print("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit: ");
			s = scr.nextLine();
			switch (s) {
			case "": {
				iterate();
				break;
			}
			case "print": {
				bd.display();
				System.out.println();
				for (Animal q : dead) {
					int[] dp = q.getpos();
					System.out
							.println(q.getClass().getSimpleName() + " died at location (" + dp[0] + "," + dp[1] + ")");
				}
				break;
			}
			default:
				break;
			}
		} while (!s.equals("exit"));
		bd.display();
		System.out.println();
		for (Animal i : For) {
			int[] p = i.getpos();
			System.out.println(i.getClass().getSimpleName() + " is now at location (" + p[0] + "," + p[1] + ")");
		}
		for (Animal i : dead) {
			int[] p = i.getpos();
			System.out.println(i.getClass().getSimpleName() + " died at location (" + p[0] + "," + p[1] + ")");
		}
	}

	/**
	 * This is the block that handles the input and then class the next block of fucntions
	 */
	private void run() {
		Scanner sc = new Scanner(System.in);
		Random rant = new Random();
		int a;
		bd.display();
		System.out.println();
		do {
			System.out.println("1. Dog (d)");
			System.out.println("2. Fox (f)");
			System.out.println("3. Wolf (w)");
			System.out.println("4. Cat (c)");
			System.out.println("5. Lion (l)");
			System.out.println("6. Tiger (t)");
			System.out.println("7. Hippo (h)");
			System.out.println("8. Turtle (u)");
			System.out.println("What would you like to add to the Forest?");
			System.out.print("Please enter your choice (1-8, or 0 to finish animal input): ");
			a = sc.nextInt();
			if (a == 0) {
				bd.display();
				Collections.sort(For);
				execute();
				break;
			} else {
				int rar = rant.nextInt(14);
				int rac = rant.nextInt(14);
				if (bd.occupied(rar, rac)) {
					do {
						rar = rant.nextInt(14);
						rar = rant.nextInt(14);
					} while (bd.occupied(rar, rac) == true);
				}
				switch (a) {
				case 1: {
					Dog d = new Dog(rar, rac, 'd');
					For.add(d);
					System.out.println("Added Dog at (" + rar + "," + rac
							+ "): Dog is Canine, Canine moves in four directions, one or two steps at a time.");
					bd.update(rar, rac, 'd');
					bd.display();
					break;
				}
				case 2: {
					Fox f = new Fox(rar, rac, 'f');
					For.add(f);
					System.out.println("Added Fox at (" + rar + "," + rac
							+ "): Fox is Canine, Canine moves in four directions, one or two steps at a time.");
					bd.update(rar, rac, 'f');
					bd.display();
					break;
				}
				case 3: {
					Wolf w = new Wolf(rar, rac, 'w');
					For.add(w);
					System.out.println("Added Wolf at (" + rar + "," + rac
							+ "): Wolf is Canine, Canine moves in four directions, one or two steps at a time.");
					bd.update(rar, rac, 'w');
					bd.display();
					break;
				}
				case 4: {
					Cat c = new Cat(rar, rac, 'c');
					For.add(c);
					System.out.println("Added Cat at (" + rar + "," + rac
							+ "): Cat is Feline, Feline moves in all eight directions, one step at a time.");
					bd.update(rar, rac, 'c');
					bd.display();
					break;
				}
				case 5: {
					Lion l = new Lion(rar, rac, 'l');
					For.add(l);
					System.out.println("Added Lion at (" + rar + "," + rac
							+ "): Lion is Feline, Feline moves in all eight directions, one step at a time.");
					bd.update(rar, rac, 'l');
					bd.display();
					break;
				}
				case 6: {
					Tiger t = new Tiger(rar, rac, 't');
					For.add(t);
					System.out.println("Added Tiger at (" + rar + "," + rac
							+ "): Tiger is Feline, Feline moves in all eight directions, one step at a time.");
					bd.update(rar, rac, 't');
					bd.display();
					break;
				}
				case 7: {
					Hippo h = new Hippo(rar, rac, 'h');
					For.add(h);
					System.out.println("Added Hippo at (" + rar + "," + rac
							+ "): Hippo moves in four directions, one step at a time.");
					bd.update(rar, rac, 'h');
					bd.display();
					break;
				}
				case 8: {
					Turtle u = new Turtle(rar, rac, 'u');
					For.add(u);
					System.out.println("Added Turtle at (" + rar + "," + rac
							+ "): Turtle either stays in the same position or moves in four directions, one step at time.");
					bd.update(rar, rac, 'u');
					bd.display();
					break;
				}
				default: {
					System.out.println("Wrong Choice entered, try again.");
					break;
				}
				}
			}
		} while (a != 0);
	}

	/**
	 * @param posa array that stores attacker's position
	 * @param posb array that stores position of animal that is being attacked
	 * @param pa index of attacker in the ArrayList
	 * @param pi index of the animal that is being attacked
	 * @return returns the result of the attack in boolean form
	 */
	private boolean action(int[] posa, int[] posb, int pa, int pi) {
		Animal s = For.get(pa);
		Animal q = For.get(pi);
		boolean res = s.attack(q);
		String a1 = s.getClass().getSimpleName();
		String a2 = q.getClass().getSimpleName();
		if (res) {
			dead.add(q);
			For.remove(pi);
			bd.update(posb[0], posb[1], s.getid());
			bd.delete(posa[0], posa[1]);
			s.update(posb[0], posb[1]);
			System.out.println(a1 + " from (" + posa[0] + ", " + posa[1] + ") attacks " + a2 + " at (" + posb[0] + ", "
					+ posb[1] + ") and wins");
			System.out.println(a2 + " dies at (" + posb[0] + ", " + posb[1] + ")");
		} else {
			dead.add(s);
			bd.delete(posa[0], posa[1]);
			For.remove(pa);
			System.out.println(a1 + " from (" + posa[0] + ", " + posa[1] + ") attacks " + a2 + " at (" + posb[0] + ", "
					+ posb[1] + ") and loses");
			System.out.println(a1 + " dies at (" + posa[0] + ", " + posa[1] + ")");
		}
		return res;

	}

	/**
	 * This block is called when user presses enter. It loops through the ArrayList and operates on each animal
	 */
	private void iterate() {
		for (int i = 0; i < For.size(); i++) {
			Animal s = For.get(i);
			int oldp[] = s.getpos();
			int newp[] = s.move();
			boolean att = false;
			boolean mov = false;
			for (int j = 0; j < For.size(); j++) {
				Animal q = For.get(j);
				int[] exp = q.getpos();
				if (newp[2] != -1 || newp[3] != -1) {// canine has moved two steps
					boolean res1 = false;
					boolean res2 = false;
					mov = true;
					int midpo[] = { newp[2], newp[3] };
					int newpo[] = { newp[0], newp[1] };
					if (Arrays.equals(midpo, exp)&&!s.equals(q)) {
						att = true;
						res1 = action(oldp, exp, i, j);
						i--;
					}
					if (Arrays.equals(newpo, exp)&&!s.equals(q)) {
						att = true;
						res2 = action(oldp, exp, i, j);
						i--;
					}
				} else {// all other animals || canine has moved one step
					int newpo[] = { newp[0], newp[1] };
					if (Arrays.equals(newpo, exp) && !Arrays.equals(oldp, newpo)&&!s.equals(q)) {
						att = true;
						boolean res = action(oldp, exp, i, j);
						i--;
					}
					if (!Arrays.equals(oldp, newpo)) {
						mov = true;
					}
				}

			}
			if (mov && !att) {

				s.update(newp[0], newp[1]);
				bd.update(newp[0], newp[1], s.getid());
				System.out.println(s.getClass().getSimpleName() + " moved from (" + oldp[0] + ", " + oldp[1] + ") to ("
						+ newp[0] + ", " + newp[1] + ")");
				bd.delete(oldp[0], oldp[1]);
			} else if (!mov && !att) {
				System.out.println(s.getClass().getSimpleName() + " stayed in (" + oldp[0] + ", " + oldp[1] + ")");
				bd.update(oldp[0], oldp[1], s.getid());
			}
		}
		bd.display();
		System.out.println();
	}
}

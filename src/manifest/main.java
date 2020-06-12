package manifest;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		System.out.println("Enter into my poker kingdom");

		Scanner scan = new Scanner(System.in);

		String[] str = scan.nextLine().split("  ");

		hand h1 = new hand(str[0]);
		hand h2 = new hand(str[1]);

		System.out.println(h1.compareTo(h2));

		scan.close();

//		for (int i = 0; i < 100; i++) {
//			deck deck = new deck();
//			h1 = new hand("black", deck.drawCard(), deck.drawCard(), deck.drawCard(), deck.drawCard(), deck.drawCard());
//			h2 = new hand("white", deck.drawCard(), deck.drawCard(), deck.drawCard(), deck.drawCard(), deck.drawCard());
//			System.out.println(h1.compareTo(h2));
//		}
	}

}

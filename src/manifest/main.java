package manifest;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		System.out.println("Enter into my poker kingdom");

		Scanner scan = new Scanner(System.in);

		hand h1 = new hand(scan.nextLine());
		hand h2 = new hand(scan.nextLine());

		System.out.println(h1.compareTo(h2));

//		for (int i = 0; i < 100; i++) {
//			deck deck = new deck();
//			h1 = new hand("black", deck.drawCard(), deck.drawCard(), deck.drawCard(), deck.drawCard(), deck.drawCard());
//			h2 = new hand("white", deck.drawCard(), deck.drawCard(), deck.drawCard(), deck.drawCard(), deck.drawCard());
//			System.out.println(h1.compareTo(h2));
//		}
	}

}

package manifest;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		System.out.println("Enter your two hands as described in the input:");

		Scanner scan = new Scanner(System.in);

		String[] str = scan.nextLine().split("  ");

		hand h1 = new hand(str[0]);
		hand h2 = new hand(str[1]);

		System.out.println(h1.compareTo(h2));

		scan.close();
	}
}

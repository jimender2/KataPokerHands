package manifest;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		System.out.println("Enter into my poker kingdom");

		Scanner scan = new Scanner(System.in);

		hand h1 = new hand(scan.nextLine());
		hand h2 = new hand(scan.nextLine());

		System.out.println(h1.compareTo(h2));
	}

}

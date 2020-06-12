package manifest;

import java.util.ArrayList;

public class util {

	public static String printWinner(hand hand, String reason) {

		String str;
		str = hand.getPlayerName() + " wins. - with " + reason + ".";

		return str;
	}

	public static int[] bubbleSort(ArrayList<card> cards) {
		int[] a = new int[cards.size()];

		for (int i = 0; i < cards.size(); i++) {
			a[i] = cards.get(i).getValue();
		}

		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					sorted = false;
				}
			}
		}

		return a;
	}

	public static int[] reverseArray(int[] input) {
		int len = input.length;
		int[] output = new int[len];

		for (int i = 0; i < len; i++) {
			output[i] = input[len - 1 - i];
		}

		return output;
	}
}

package manifest;

import java.util.ArrayList;

public class hand {

	String name;
	ArrayList<card> cards;
	int[] value;

	public hand(String name, String str) {
		this.name = name;

		value = new int[8];

		String[] strSplit = str.split(" ");

		for (String s : strSplit) {
			cards.add(new card(s));
		}
	}

	String getPlayerName() {
		return name;
	}

	void display() {
		// Change out to use variable to make it faster.
		for (int i = 0; i < cards.size(); i++) {

		}
	}

}

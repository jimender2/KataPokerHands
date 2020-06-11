package manifest;

import java.util.ArrayList;

public class hand {

	String name;
	ArrayList<card> cards;
	int[] value;

	/**
	 * Default Constructor
	 * 
	 * @param name
	 * @param str
	 */
	public hand(String str) {

		String[] strSplit = str.split(": ");
		this.name = strSplit[0];

		strSplit = strSplit[1].split(" ");

		this.cards = new ArrayList<card>();
		// Add cards to the hand (an array list for simplicity)
		for (String s : strSplit) {
			this.cards.add(new card(s));
		}

		// Count the number of each type of card in my hand (ie 2 2s 1 4 and 1K)
		// This preps for the pair, two pair, three of a kind, and four of a kind

		// index 2 = 2
		// index 3 = 3
		// etc...
		// index 0 and 1 should be blank. This is to map the numbers to their
		// number easier
		int[] count = new int[15];
		for (int i = 0; i < 15; i++) {
			count[i] = 0;
		}

		for (card card : cards) {
			count[card.getValue()]++;
		}

		boolean pair = false;
		boolean twoPair = false;
		boolean threeOfAKind = false;
		boolean fourOfAKind = false;

		int pairNum;
		int twoPairNum;
		int threeOfAKindNum;
		int fourOfAKindNum;

		for (int i : count) {
			if (i == 2) {
				if (!pair) {
					pair = true;
					pairNum = i;
				} else {
					twoPair = true;
					twoPairNum = i;
				}
			} else if (i == 3) {
				threeOfAKind = true;
				threeOfAKindNum = i;
			} else if (i == 4) {
				fourOfAKind = true;
				fourOfAKindNum = i;
			}
		}

	}

	/**
	 * getPlayerName
	 * 
	 * @return Returns the players name (ie Black or White)
	 */
	String getPlayerName() {
		return name;
	}

	void display() {
		// Change out to use variable to make it faster.
		for (int i = 0; i < cards.size(); i++) {

		}
	}

	int compareTo(hand other) {
		int returnInt = 0;

		// Change the values to return sooner
		for (int i = 0; i < value.length; i++) {
			if (this.value[i] < other.value[i]) {
				returnInt = -1;
				break;
			} else if (this.value[i] > other.value[i]) {
				returnInt = 1;
				break;
			}
		}
		return returnInt;
	}
}

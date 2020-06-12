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

		int pairNum = 0;
		int twoPairNum = 0;
		int threeOfAKindNum = 0;
		int fourOfAKindNum = 0;

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

		boolean fullHouse = false;
		int fullHouseNum;
		// Now to check if it is Full house
		if (twoPair && threeOfAKind) {
			fullHouse = true;
			fullHouseNum = threeOfAKindNum;
		}

		// Check for a Flush
		boolean straight = false;
		int straightNum = 0;
		int consecutive = 0;
		for (int i : count) {
			if (i == 1) {
				consecutive = consecutive + 1;
			} else if (i > 1) {
				// Does not make sense to keep running through if we already have
				// consecutive cards since there are multiple cards of this value
				// in this pile
				break;
			} else if (i == 0 && consecutive != 0) {
				// Does not make sense to keep running through if we already have
				// consecutive cards since there are no cards in this pile and
				// we already have consecutive cards
				break;
			}

			if (consecutive == 5) {
				straight = true;
				straightNum = i;
				break;
			}
		}

		// Flush
		boolean flush = false;
		int[] suit = new int[4];
		for (int i = 0; i < 4; i++) {
			suit[i] = 0;
		}

		for (card card : cards) {
			switch (card.getSuit()) {
			case 'D':
				suit[0] = suit[0] + 1;
				break;
			case 'H':
				suit[1] = suit[1] + 1;
				break;
			case 'C':
				suit[2] = suit[2] + 1;
				break;
			case 'S':
				suit[3] = suit[3] + 1;
				break;
			}
		}

		for (int i : suit) {
			if (i == 5) {
				flush = true;
			}
		}

		boolean straightFlush = false;
		if (straight && flush) {
			straightFlush = true;
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

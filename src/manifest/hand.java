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

	String compareTo(hand other) {
		score h1 = new score(this.cards);
		score h2 = new score(other.cards);

		// Catches any straight flushes that there might be
		if (h1.straightFlush) {
			return util.printWinner(this, "straight flush");
		} else if (h2.straightFlush) {
			return util.printWinner(other, "straight flush");
		}

		// Handles the four of a kinds
		if (h1.fourOfAKind && h2.fourOfAKind) {
			if (h1.fourOfAKindNum > h2.fourOfAKindNum) {
				return util.printWinner(this, "four of a kind");
			} else {
				return util.printWinner(other, "four of a kind");
			}
		} else if (h1.fourOfAKind) {
			return util.printWinner(this, "four of a kind");
		} else if (h2.fourOfAKind) {
			return util.printWinner(other, "four of a kind");
		}

		// Handles full houses.
		if (h1.fullHouse && h2.fullHouse) {
			if (h1.fullHouseNum > h2.fullHouseNum) {
				return util.printWinner(this, "a full house");
			} else {
				return util.printWinner(other, " wins. - whth a full house");
			}
		} else if (h1.fullHouse) {
			return util.printWinner(this, "a full house.");
		} else if (h2.fullHouse) {
			return util.printWinner(other, "a full house");
		}

		// Catches any flushes that there might be.
		if (h1.flush && h2.flush) {
			// todo
		} else if (h1.flush) {
			return util.printWinner(this, "a flush");
		} else if (h2.flush) {
			return util.printWinner(other, "a flush");
		}

		// Catch the straights
		if (h1.straight && h2.straight) {
			if (h1.straightNum > h2.straightNum) {
				return util.printWinner(this, "a straight");
			} else {
				return util.printWinner(other, "a straight");
			}
		} else if (h1.straight) {
			return util.printWinner(this, "a straight");
		} else if (h2.straight) {
			return util.printWinner(other, "a straight");
		}

		// Three cards are the same
		if (h1.threeOfAKind && h2.threeOfAKind) {
			if (h1.threeOfAKindNum > h2.threeOfAKindNum) {
				return util.printWinner(this, "a three of a kind");
			} else {
				return util.printWinner(other, "a three of a kind");
			}
		} else if (h1.threeOfAKind) {
			return util.printWinner(this, "a three of a kind");
		} else if (h2.threeOfAKind) {
			return util.printWinner(other, "a three of a kind");
		}

		// A pair of pairs is caught here.
		if (h1.twoPair && h2.twoPair) {
			// Since I do not sort out which one is bigger in the score class
			// I need to sort it out here.
			// Move to util class.
			int h1num = 0;
			if (h1.twoPairNum >= h1.pairNum) {
				h1num = h1.twoPairNum;
			} else {
				h1num = h1.pairNum;
			}

			int h2num = 0;
			if (h2.twoPairNum >= h2.pairNum) {
				h2num = h2.twoPairNum;
			} else {
				h2num = h2.pairNum;
			}

			if (h1num > h2num) {
				return util.printWinner(this, "a two pair");
			} else {
				return util.printWinner(other, "a two pair");
			} // todo handle if both pairs are the same value
		} else if (h1.twoPair) {
			return util.printWinner(this, "a two pair");
		} else if (h2.twoPair) {
			return util.printWinner(other, "a two pair");
		}

		// Single pair. No need to sort it.
		if (h1.pair && h2.pair) {
			if (h1.pairNum > h2.pairNum) {
				return util.printWinner(this, "a pair");
			} else {
				return util.printWinner(other, "a pair");
			}
			// todo need to handle if both pairs are the same value
		} else if (h1.pair) {
			return util.printWinner(this, "a pair");
		} else if (h2.pair) {
			return util.printWinner(other, "a pair");
		}

		// This section is for the high card selection.
		int len = h1.highNum.length - 1;
		for (int i = 0; i < h1.highNum.length; i++) {
			if (h1.highNum[i] > h2.highNum[i]) {
				return util.printWinner(this, "high card: " + card.getName(h1.highNum[i]));
			} else if (h1.highNum[i] < h2.highNum[i]) {
				return util.printWinner(other, "high card: " + card.getName(h2.highNum[i]));
			}
		}

		// If nothing above was triggered, it must be a tie.
		return "Tie.";

	}
}

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

		if (h1.straightFlush) {
			return this.getPlayerName() + " wins. - with straight flush.";
		} else if (h2.straightFlush) {
			return other.getPlayerName() + " wins. - with straight flush.";
		} else if (h1.fourOfAKind && h2.fourOfAKind) {
			if (h1.fourOfAKindNum > h2.fourOfAKindNum) {
				return this.getPlayerName() + " wins. - with four of a kind";
			} else {
				return other.getPlayerName() + " wins. - with four of a kind";
			}
		} else if (h1.fourOfAKind) {
			return this.getPlayerName() + " wins. - with four of a kind";
		} else if (h2.fourOfAKind) {
			return other.getPlayerName() + " wins. - with four of a kind";
		} else if (h1.fullHouse && h2.fullHouse) {
			if (h1.fullHouseNum > h2.fullHouseNum) {
				return this.getPlayerName() + " wins. - with a full house";
			} else {
				return other.getPlayerName() + " wins. - whth a full house";
			}
		} else if (h1.fullHouse) {
			return this.getPlayerName() + " wins. - with a full house.";
		} else if (h2.fullHouse) {
			return other.getPlayerName() + " wins. - with a full house";
		} else if (h1.flush && h2.flush) {
			// todo
		} else if (h1.flush) {
			return this.getPlayerName() + " wins. - with a flush";
		} else if (h2.flush) {
			return other.getPlayerName() + " wins. - with a flush";
		} else if (h1.straight && h2.straight) {
			if (h1.straightNum > h2.straightNum) {
				return this.getPlayerName() + " wins. - with a straight";
			} else {
				return other.getPlayerName() + " wins. - with a straight";
			}
		} else if (h1.straight) {
			return this.getPlayerName() + " wins. - with a straight";
		} else if (h2.straight) {
			return other.getPlayerName() + " wins. - with a straight";
		} else if (h1.threeOfAKind && h2.threeOfAKind) {
			if (h1.threeOfAKindNum > h2.threeOfAKindNum) {
				return this.getPlayerName() + " wins. - with a three of a kind";
			} else {
				return other.getPlayerName() + " wins. - with a three of a kind";
			}
		} else if (h1.threeOfAKind) {
			return this.getPlayerName() + " wins. - with a three of a kind";
		} else if (h2.threeOfAKind) {
			return other.getPlayerName() + " wins. - with a three of a kind";
		} else if (h1.twoPair && h2.twoPair) {
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
				return this.getPlayerName() + " wins. - with a two pair";
			} else {
				return other.getPlayerName() + " wins. - with a two pair";
			}
		} else if (h1.twoPair) {
			return this.getPlayerName() + " wins. - with a two pair";
		} else if (h2.twoPair) {
			return other.getPlayerName() + " wins. - with a two pair";
		} else if (h1.pair && h2.pair) {
			if (h1.pairNum > h2.pairNum) {
				return this.getPlayerName() + " wins. - with a pair";
			} else {
				return other.getPlayerName() + " wins. - with a two pair";
			}
		} else if (h1.pair) {
			return this.getPlayerName() + " wins. - with a two pair";
		} else if (h2.pair) {
			return other.getPlayerName() + " wins. - with a two pair";
		} else {
			for (int i = 0; i < h1.highNum.length; i++) {
				int len = h1.highNum.length - 1;
				if (h1.highNum[len - i] > h2.highNum[len - i]) {
					return this.getPlayerName() + " wins. - with high card: " + card.getName(h1.highNum[len - i]);
				} else if (h1.highNum[len - i] < h2.highNum[len - i]) {
					return other.getPlayerName() + " wins. - with high card: " + card.getName(h2.highNum[len - i]);
				}
			}
			return "Tie.";
		}

		return "";
	}
}

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

	public hand(String name, card card1, card card2, card card3, card card4, card card5) {

		this.name = name;

		this.cards = new ArrayList<card>();
		// Add cards to the hand (an array list for simplicity)
		this.cards.add(card1);
		this.cards.add(card2);
		this.cards.add(card3);
		this.cards.add(card4);
		this.cards.add(card5);
	}

	/**
	 * getPlayerName
	 * 
	 * @return Returns the players name (ie Black or White)
	 */
	String getPlayerName() {
		return name;
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
				return util.printWinner(other, "a full house");
			}
		} else if (h1.fullHouse) {
			return util.printWinner(this, "a full house");
		} else if (h2.fullHouse) {
			return util.printWinner(other, "a full house");
		}

		// Catches any flushes that there might be.
		if (h1.flush && h2.flush) {
			// This section is for the high card selection.
			for (int i = 0; i < h1.highNum.length; i++) {
				if (h1.highNum[i] > h2.highNum[i]) {
					return util.printWinner(this, "high card: " + card.getName(h1.highNum[i]));
				} else if (h1.highNum[i] < h2.highNum[i]) {
					return util.printWinner(other, "high card: " + card.getName(h2.highNum[i]));
				}
			}

			// If nothing above was triggered, it must be a tie.
			return "Tie.";
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
			int h1num = util.maxNumber(h1.pairNum, h2.twoPairNum);

			int h2num = util.maxNumber(h2.pairNum, h2.twoPairNum);

			if (h1num > h2num) {
				return util.printWinner(this, "a two pair");
			} else if (h1num < h2num) {
				return util.printWinner(other, "a two pair");
			} else {
				int h1numl = util.minNumber(h1.pairNum, h2.twoPairNum);

				int h2numl = util.minNumber(h2.pairNum, h2.twoPairNum);

				if (h1numl > h2numl) {
					return util.printWinner(this, "a two pair");
				} else if (h1numl < h2numl) {
					return util.printWinner(other, "a two pair");
				} else {
					// All four pairs must be equal (two pairs of pairs)
					// so I need to handle
					// based on the highest number not in the pairs.
					int[] pair1 = new int[1];
					int[] pair2 = new int[1];
					int tracker1 = 0;
					int tracker2 = 0;
					for (int i = 0; i < h1.highNum.length; i++) {
						if (h1.highNum[i] != h1num && h1.highNum[i] != h1numl) {
							pair1[tracker1] = h1.pairNum;
						}
						if (h2.highNum[i] != h1num && h2.highNum[i] != h1numl) {
							pair2[tracker2] = h2.pairNum;
						}
					}
				}
			}

		} else if (h1.twoPair) {
			return util.printWinner(this, "a two pair");
		} else if (h2.twoPair) {
			return util.printWinner(other, "a two pair");
		}

		// Single pair. No need to sort it.
		if (h1.pair && h2.pair) {
			if (h1.pairNum > h2.pairNum) {
				return util.printWinner(this, "a pair");
			} else if (h1.pairNum < h2.pairNum) {
				return util.printWinner(other, "a pair");
			} else {
				// Both pairs must be the same number so I need to handle
				// based on the highest number not in the pairs.
				int[] pair1 = new int[3];
				int[] pair2 = new int[3];
				int tracker1 = 0;
				int tracker2 = 0;
				for (int i = 0; i < h1.highNum.length; i++) {
					if (h1.highNum[i] != h1.pairNum) {
						pair1[tracker1] = h1.pairNum;
					}
					if (h2.highNum[i] != h2.pairNum) {
						pair2[tracker2] = h2.pairNum;
					}
				}
			}

		} else if (h1.pair) {
			return util.printWinner(this, "a pair");
		} else if (h2.pair) {
			return util.printWinner(other, "a pair");
		}

		// This section is for the high card selection.
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

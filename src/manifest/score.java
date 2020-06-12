package manifest;

import java.util.ArrayList;

public class score {
	boolean pair;
	boolean twoPair;
	boolean threeOfAKind;
	boolean fourOfAKind;
	boolean fullHouse;
	boolean straight;
	boolean flush;
	boolean straightFlush;

	int pairNum;
	int twoPairNum;
	int threeOfAKindNum;
	int fourOfAKindNum;
	int fullHouseNum;
	int straightNum;

	int[] highNum;

	score(ArrayList<card> cards) {

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

		pair = false;
		twoPair = false;
		threeOfAKind = false;
		fourOfAKind = false;

		pairNum = 0;
		twoPairNum = 0;
		threeOfAKindNum = 0;
		fourOfAKindNum = 0;

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

		fullHouse = false;
		fullHouseNum = 0;
		// Now to check if it is Full house
		if (pair && threeOfAKind) {
			fullHouse = true;
			fullHouseNum = threeOfAKindNum;
		}

		// Check for a Flush
		straight = false;
		straightNum = 0;
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
		flush = false;
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

		straightFlush = false;
		if (straight && flush) {
			straightFlush = true;
		}

		highNum = bubbleSort(cards);

	}

	int[] bubbleSort(ArrayList<card> cards) {
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

}

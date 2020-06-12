package manifest;

public class card {

	char suit;
	char rank;

	public card(char suit, char rank) {
		this.suit = suit;
		this.rank = rank;
	}

	card(String str) {
		suit = str.charAt(1);
		rank = str.charAt(0);
	}

	char getSuit() {
		return suit;
	}

	char getRank() {
		return rank;
	}

	public int getValue() {

		int value = 0;

		switch (this.rank) {
		case 'J':
			value = 11;
			break;
		case 'Q':
			value = 12;
			break;
		case 'K':
			value = 13;
			break;
		case 'A':
			value = 14;
			break;
		case '1':
			// Need to catch this case since 1 is not a valid card value
			value = 10;
			break;
		default:
			value = ((int) rank) - 48;
			break;
		}

		return value;

	}

	public static String getName(int value) {

		String str = "";

		switch (value) {
		case 11:
			str = "Jack";
			break;
		case 12:
			str = "Queen";
			break;
		case 13:
			str = "King";
			break;
		case 14:
			str = "Ace";
			break;
		default:
			str = value + "";
			break;
		}

		return str;

	}
}

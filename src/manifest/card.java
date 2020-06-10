package manifest;

public class card {

	char suit;
	char rank;

	public card(char suit, char rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public card(String str) {
		suit = str.charAt(1);
		rank = str.charAt(0);
	}

	public char suit() {
		return suit;
	}

	public char rank() {
		return rank;
	}
}
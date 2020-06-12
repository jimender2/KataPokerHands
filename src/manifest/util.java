package manifest;

public class util {

	public static String printWinner(hand hand, String reason) {

		String str;
		str = hand.getPlayerName() + " wins. - with " + reason + ".";

		return str;
	}
}

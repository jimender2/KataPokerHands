package manifest;

import java.util.ArrayList;
import java.util.Random;

public class deck {

	private ArrayList<card> deck;

	deck() {
		deck = new ArrayList<card>();

		Random rand = new Random();

		int rand1, rand2;

		card card;

		String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		String[] suit = { "D", "S", "C", "H" };

		// Make a deck of 52 cards
		for (String i : rank) {
			for (String s : suit) {
				deck.add(new card(i + s));
			}
		}

		// Shuffle the deck.
		for (int i = 0; i < 1000; i++) {
			rand1 = rand.nextInt(52);
			rand2 = rand.nextInt(52);

			card = deck.get(rand1);
			deck.set(rand1, deck.get(rand2));
			deck.set(rand2, card);
		}

	}

	public card drawCard() {
		// Remove the card on top (the one on the end)
		return deck.remove(deck.size() - 1);
	}
}

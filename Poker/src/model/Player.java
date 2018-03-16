package model;

import java.util.ArrayList;

public class Player implements Comparable<Player> {

	public static final int HAND_SIZE = 5;
	private final String playerName; // This is the ID
	private final ArrayList<Card> playerCards = new ArrayList<>();
	private Hand handType;

	/**
	 *
	 * private Card[] cards = new Card[5]; public void add(Card card) { for (int i =
	 * 0; i < cards.length; i++) cards[i] = new Card(card.getType(),
	 * card.getCardValue()); }
	 * 
	 * public String toString() { String display = ""; display = cards[0].toString()
	 * + cards[1].toString() + cards[2].toString() + cards[3].toString() +
	 * cards[4].toString(); return display; }
	 */

	public Player(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public ArrayList<Card> getCards() {
		return playerCards;
	}

	public void addCard(Card card) {
		if (playerCards.size() < HAND_SIZE)
			playerCards.add(card);
	}

	public void discardHand() {
		playerCards.clear();
		handType = null;
	}

	public int getNumCards() {
		return playerCards.size();
	}

	public Hand evaluateHand() {
		if (handType == null && playerCards.size() == HAND_SIZE) {
			handType = Hand.evaluateHand(playerCards);
		}
		return handType;
	}

	@Override
	public int compareTo(Player o) {
		return handType.compareTo(o.handType);
	}

}

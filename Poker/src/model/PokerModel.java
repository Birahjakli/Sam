package model;

import java.util.ArrayList;

import Game.PokerGame;

public class PokerModel {
	private final ArrayList<Player> players = new ArrayList<>();
	private CardDeck deck;

	public PokerModel() {
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			players.add(new Player("Player " + i));
		}

		deck = new CardDeck();
	}

	public Player getPlayer(int i) {
		return players.get(i);
	}

	public CardDeck getDeck() {
		return deck;
	}
}

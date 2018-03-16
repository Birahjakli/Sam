package view;

import javafx.scene.control.Label;
import model.CardDeck;


public class DeckLabel extends Label {
	public DeckLabel() {
		super();
		this.getStyleClass().add("deck");
	}
	
	// Bind the label to the CardsRemaining property of the deck
	public void setDeck(CardDeck deck) {
		deck.LeftCards();
	}
}

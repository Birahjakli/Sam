package controller;

import Game.PokerGame;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Card;
import model.CardDeck;
import model.Player;
import model.PokerModel;
import view.PlayerPane;
import view.PokerGView;



public class Controller {
	
	
		private PokerModel model;
		private PokerGView view;
		
		public Controller(PokerModel model, PokerGView view) {
			this.model = model;
			this.view = view;
			
			view.getShuffleButton().setOnAction( e -> shuffle() );
			view.getDealButton().setOnAction( e -> deal() );
		}
		


	    /**
	     * Remove all cards from players hands, and shuffle the deck
	     */
	    private void shuffle() {
	    	for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
	    		Player p = model.getPlayer(i);
	    		p.discardHand();
	    		PlayerPane pp = view.getPlayerPane(i);
	    		pp.updatePlayerDisplay();
	    	}

	    	model.getDeck().shuffle();
	    }
	    
	    /**
	     * Deal each player five cards, then evaluate the two hands
	     */
	    private void deal() {
	    	int cardsRequired = PokerGame.NUM_PLAYERS * Player.HAND_SIZE;
	    	CardDeck deck = model.getDeck();
	    	if (cardsRequired <= deck.LeftCards()) {
	    		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
	        		Player p = model.getPlayer(i);
	        		p.discardHand();
	        		for (int j = 0; j < Player.HAND_SIZE; j++) {
	        			Card card = deck.DealACard();
	        			p.addCard(card);
	        		}
	        		p.evaluateHand();
	        		PlayerPane pp = view.getPlayerPane(i);
	        		pp.updatePlayerDisplay();
	        	}
	    	} else {
	            Alert alert = new Alert(AlertType.ERROR, "Not enough cards - shuffle first");
	            alert.showAndWait();
	    	}
	    }
	}




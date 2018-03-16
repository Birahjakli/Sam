package model;

import java.awt.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;



public class CardDeck {
	
	

	private final Integer cardNames[] = {2,3,4,5,6,7,8,9,10,11,12,13,14};
	private final String types[] = {"S", "C", "H", "D"};

    private Card CardDeck[];
    private final int AllCards=52;
    private Random randCard;   
   
 // Add all 52 cards
    public CardDeck(){        
    	CardDeck = new Card[AllCards];
        
        for(int i=0;i<CardDeck.length;i++){
        	CardDeck[i] = new Card(cardNames[i%13],types[i/13]);
        }
        
      
   
    }
    
    //to shuffle
    public void shuffle(){
        for(int i=0;i<CardDeck.length;i++){
        	 int ii = randCard.nextInt(AllCards);
        	 Card NCard = CardDeck[i];
            CardDeck[i] = CardDeck[ii];
            CardDeck[ii] = NCard;
        }
    }        
	
    //deal a card from the deck and return it
    
    public Card DealACard(){
    	if (CardDeck.length > 0) {
    		Card card = CardDeck[CardDeck.length -1] ; 
        	
    		CardDeck =  Arrays.copyOf(CardDeck, CardDeck.length -1);
    		
    		
        	
    	 return card;
    	}else {
    		return null;
    	}
    	
    }
    
    //How many cards are left in the deck?
    
    public int LeftCards() {
     int x = CardDeck.length;
    return x;
    }

}

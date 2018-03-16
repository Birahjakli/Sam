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
    // Add all 52 cards
    public CardDeck(){        
    	CardDeck = new Card[this.AllCards];
        
        for(int i=0;i<this.CardDeck.length;i++){
        	this.CardDeck[i] = new Card(this.cardNames[i%13],this.types[i/13]);
        }
        
      
   
    }
    
    
    public void NewDeck(){ 
    for (int i = 0; i < this.CardDeck.length; i++) {
		
    	
		this.CardDeck[i] = null;
    }

	}
    //to shuffle
    public void shuffle(){
    	
    	
        for(int i=0;i<this.CardDeck.length;i++){
        	Random randCard = new Random();
        	 int ii = randCard.nextInt(AllCards);
        	 Card NCard = CardDeck[i];
            this.CardDeck[i] = this.CardDeck[ii];
            this.CardDeck[ii] = NCard;
        }
    }        
	
    //deal a card from the deck and return it
    
    public Card DealACard(){
    	if (this.CardDeck.length > 0) {
    		Card card = this.CardDeck[this.CardDeck.length -1] ; 
        	
    		this.CardDeck =  Arrays.copyOf(this.CardDeck, this.CardDeck.length -1);
    		
    		
        	
    	 return card;
    	}else {
    		return null;
    	}
    	
    }
    
    //How many cards are left in the deck?
    
    public int LeftCards() {
     int x = this.CardDeck.length;
    return x;
    }

}

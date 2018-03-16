package model;



public class Card {
	//private String cardName;
	public String type;
	public Integer cardValue;
	
	
	public Card( Integer cardValue,String type) {
		this.type = type;
	
		this.cardValue = cardValue;
		
	}

	public Integer getCardValue() {
		return cardValue;
	}

	
    public String getType() {
		return type;
	}

	
	
	@Override
    public String toString() {
        return type.toString() + cardValue.toString();
    }
	
	
}

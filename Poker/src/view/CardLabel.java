package view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;
import model.CardDeck;


public class CardLabel extends Label {
	public CardLabel() {
		super();
		this.getStyleClass().add("card");
	}

	
	
	public String cardPics(Card card) {
		String type = card.getType().toString();
		Integer cardValue = card.getCardValue();
		return cardValue + type+".png";
	}
	
	
	
	
	public void setCard(Card card) {
		if (card != null) {
			String cardImage = cardPics(card);
			Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("poker/images/" + cardImage));
			ImageView imagev = new ImageView(image);
			imagev.fitWidthProperty().bind(this.widthProperty());
			imagev.fitHeightProperty().bind(this.heightProperty());
			imagev.setPreserveRatio(true);
			this.setGraphic(imagev);
		} else {
			this.setGraphic(null);
		}
	}



}

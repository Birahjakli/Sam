package model;

import java.util.ArrayList;



public enum Hand {
	HighCard, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush, RoyalFlush;

	/**
	 * 
	 */
	public static Hand evaluateHand(ArrayList<Card> cards) {
		Hand currentEval = HighCard;

		if (isOnePair(cards))
			currentEval = OnePair;
		if (isTwoPair(cards))
			currentEval = TwoPair;
		if (isThreeOfAKind(cards))
			currentEval = ThreeOfAKind;
		if (isStraight(cards))
			currentEval = Straight;
		if (isFlush(cards))
			currentEval = Flush;
		if (isFullHouse(cards))
			currentEval = FullHouse;
		if (isFourOfAKind(cards))
			currentEval = FourOfAKind;
		if (isStraightFlush(cards))
			currentEval = StraightFlush;
		if (isRoyalFlush(cards))
			currentEval = RoyalFlush;

		return currentEval;
	}

	private static boolean isOnePair(ArrayList<Card> cards) {
		boolean found = false;
		for (int i = 0; i < cards.size() - 1 && !found; i++) {
			for (int j = i + 1; j < cards.size() && !found; j++) {
				if (cards.get(i).getCardValue() == cards.get(j).getCardValue()) {
					found = true;
				}
			}
		}
		return found;
	}

	private static boolean isTwoPair(ArrayList<Card> cards) {
		// Clone the cards, because we will be altering the list
		ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();

		// Find the first pair; if found, remove the cards from the list
		boolean firstPairFound = false;
		for (int i = 0; i < clonedCards.size() - 1 && !firstPairFound; i++) {
			for (int j = i + 1; j < clonedCards.size() && !firstPairFound; j++) {
				if (clonedCards.get(i).getCardValue() == clonedCards.get(j).getCardValue()) {
					firstPairFound = true;
					clonedCards.remove(j); // Remove the later card
					clonedCards.remove(i); // Before the earlier one
				}
			}
		}
		// If a first pair was found, see if there is a second pair
		return firstPairFound && isOnePair(clonedCards);
	}

	private static boolean isThreeOfAKind(ArrayList<Card> cards) {
		boolean found = false;
		for (int i = 0; i < cards.size() - 2; i++) {
			for (int j = i + 1; j < cards.size() - 1; j++) {
				for (int k = j + 1; k < cards.size(); k++) {
					if (cards.get(i).getCardValue() == cards.get(j).getCardValue()
							&& cards.get(j).getCardValue() == cards.get(k).getCardValue()) {
						found = true;
					}
				}
			}
		}
		return found;
	}

	private static boolean isStraight(ArrayList<Card> cards) {
		int tm = 0;
		boolean found = false;
		int[] array = new int[5];
		int i = 0;
		int temp = 0;
		int x = 0;
		int indexOfSmallest = 0;
		while (i < array.length) {
			array[i] = cards.get(i).getCardValue();	
			i++;
		}
		i = 0;

		while (i < array.length) {

			indexOfSmallest = i;
			x = i + 1;

			while (x < array.length) {

				if (array[x] < array[i]) {

					indexOfSmallest = x;

					// start swap
					temp = array[i];
					array[i] = array[indexOfSmallest];
					array[indexOfSmallest] = temp;
					// end swap

				}

				x++;

			}

			// old swap

			i++;
		}

		if (array[0] + 5 == array[1] + 4 && array[1] + 4 == array[2] + 3 && array[2] + 3 == array[3] + 2
				&& array[3] + 2 == array[4] + 1)
			found = true;
		for (int l = 0; l < array.length; l++) {
			if (array[l] == 12) {
				array[l] = -1;
				tm = array[l];
			}
		}
		for (i = 3; i >= 0; i--) {
			array[i + 1] = array[i];
		}
		array[0] = tm;
		if (array[0] + 5 == array[1] + 4 && array[1] + 4 == array[2] + 3 && array[2] + 3 == array[3] + 2
				&& array[3] + 2 == array[4] + 1)
			found = true;

		return found;
	}

	private static boolean isFlush(ArrayList<Card> cards) {
		boolean found = false;
		if (cards.get(0).getType() == cards.get(1).getType() && cards.get(1).getType() == cards.get(2).getType()
				&& cards.get(2).getType() == cards.get(3).getType()
				&& cards.get(3).getType() == cards.get(4).getType()) {
			found = true;
		}
		return found;
	}

	private static boolean isFullHouse(ArrayList<Card> cards) {
		ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();

		// Find the first pair; if found, remove the cards from the list
		boolean firstPairFound = false;
		for (int i = 0; i < clonedCards.size() - 1 && !firstPairFound; i++) {
			for (int j = i + 1; j < clonedCards.size() && !firstPairFound; j++) {
				if (clonedCards.get(i).getCardValue() == clonedCards.get(j).getCardValue()) {
					firstPairFound = true;
					clonedCards.remove(j); // Remove the later card
					clonedCards.remove(i); // Before the earlier one
				}
			}
		}
		return firstPairFound && isThreeOfAKind(clonedCards);
	}

	private static boolean isFourOfAKind(ArrayList<Card> cards) {
		boolean found = false;
		for (int i = 0; i < cards.size() - 2; i++) {
			for (int j = i + 1; j < cards.size() - 1; j++) {
				for (int k = j + 1; k < cards.size(); k++) {
					for (int l = k + 1; l < cards.size(); l++) {
						if (cards.get(i).getCardValue() == cards.get(j).getCardValue()
								&& cards.get(j).getCardValue() == cards.get(k).getCardValue()
								&& cards.get(k).getCardValue() == cards.get(l).getCardValue()) {
							found = true;
						}
					}
				}
			}
		}
		return found;
	}

	private static boolean isStraightFlush(ArrayList<Card> cards) {

		return isFlush(cards) && isStraight(cards);
	}

	private static boolean isRoyalFlush(ArrayList<Card> cards) {
		boolean result = false;
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getCardValue()==12) {
				result = true;
			}
		}
		return result && isStraightFlush(cards);
	}
}



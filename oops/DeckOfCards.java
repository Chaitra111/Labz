package com.bridgelabz.oops;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class DeckOfCards {

	public static void main(String[] args) {
		String[] suits = { "Clubs", "Diamond", "Hearts", "Spades" };
		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		String[][] deck = new String[suits.length][cards.length];

		deck = intializecards(deck, suits, cards);
		deck = shuffle(deck, suits.length, cards.length);

		printcards(deck);
	}

	public static String[][] intializecards(String[][] deck, String[] suits, String[] cards) {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				deck[i][j] = suits[i] + "-" + cards[j];
			}
		}
		return deck;
	}

	public static String[][] shuffle(String[][] deck, int suitsize, int cardsize) {
		for (int i = 0; i < suitsize; i++) {
			for (int j = 0; j < cardsize; j++) {
				int randomValue1 = (int) (Math.random() * suitsize);
				int randomValue2 = (int) (Math.random() * cardsize);
				String temp = deck[randomValue1][randomValue2];
				deck[randomValue1][randomValue2] = deck[i][j];
				deck[i][j] = temp;
			}
		}
		return deck;
	}

	public static void printcards(String[][] deck) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(deck[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
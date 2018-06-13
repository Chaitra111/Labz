package com.bridgelabz.oops;

import com.bridgelabz.DataStructure.QueueUsingLinkedlist;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :
 */
public class DeckOfCardsQueue {

	static String[] suits = { "Clubs", "Diamond", "Hearts", "Spades" };
	static String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	static String[][] deck = new String[suits.length][cards.length];

	public static void main(String[] args) {
		deck = intializecards(deck, suits, cards);
		deck = shuffle(deck, suits.length, cards.length);
		String[] player1 = new String[9];
		String[] player2 = new String[9];
		String[] player3 = new String[9];
		String[] player4 = new String[9];

		QueueUsingLinkedlist queue1 = new QueueUsingLinkedlist();
		QueueUsingLinkedlist queue2 = new QueueUsingLinkedlist();
		QueueUsingLinkedlist queue3 = new QueueUsingLinkedlist();
		QueueUsingLinkedlist queue4 = new QueueUsingLinkedlist();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == 0) {
					player1[i] = suits[i] + "-" + cards[j];
					queue1.insert(deck[i][j]);
				} else if (i == 1) {
					player2[i] = suits[i] + "-" + cards[j];
					queue2.insert(deck[i][j]);
				} else if (i == 2) {
					player3[i] = suits[i] + "-" + cards[j];
					queue3.insert(deck[i][j]);
				} else if (i == 3) {
					player4[i] = suits[i] + "-" + cards[j];
					queue4.insert(deck[i][j]);
				}
			}
		}
		queue1.display();
		System.out.println();
		queue2.display();
		System.out.println();
		queue3.display();
		System.out.println();
		queue4.display();
	}

	public static String[][] intializecards(String[][] deck, String[] suits, String[] cards) {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				deck[i][j] = suits[i] + "-" + cards[j] + "\t";
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
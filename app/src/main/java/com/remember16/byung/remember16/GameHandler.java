package com.remember16.byung.remember16;

import android.view.View;
import android.view.animation.Animation;

import java.util.Stack;
import java.util.Timer;

/**
 * Created by byung on 12/19/14.
 */
//TO DO: create a singleton handler(?) think of some design.

public class GameHandler {
    private Deck deck;
    private static int counter = 0;
    private static boolean doubleChance = false;
    private static Stack<Card> cardStack = new Stack<Card>();
    private Timer timer;

    //buttonIds, view, rotation
    public GameHandler(int[] buttonIds, View view, Animation[] rotations) {
        deck = new Deck(buttonIds, view, rotations);
    }

    public static void incCounter() {
        counter++;
        if(counter == 3 && !doubleChance) {
            //Verify
            while(!cardStack.isEmpty()) {
                Card card = cardStack.pop();
                card.flip();
            }
            cardStack.removeAllElements();
            counter = 0;
        } else if(counter == 5 && !doubleChance) {
//            //Verify
//            while(!cardStack.isEmpty()) {
//                Card card = cardStack.pop();
//                card.flip();
//            }
//            cardStack.removeAllElements();
//            counter = 0;
        }
    }

    public static void addToStack(Card card) {

        cardStack.push(card);
        incCounter();
    }

    public void flipAll() {
        for(int i=0;i<16;i++) {
            Card card = deck.getCardAt(i);
            card.flip();
        }
    }

}

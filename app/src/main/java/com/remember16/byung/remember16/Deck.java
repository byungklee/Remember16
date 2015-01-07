package com.remember16.byung.remember16;

import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by byung on 12/19/14.
 */
public class Deck {
    //create 16 cards
    private final int NUMBER_OF_CARDS = 16;
    private final int PICK_NUMBER = 1;

    private HashMap<String, Boolean> duplicationChecker;


    private Card[] cards;
    public Deck(int[] buttonIds, View view, Animation[] animations) {
        cards = new Card[NUMBER_OF_CARDS];

        duplicationChecker = new HashMap<String, Boolean>();
        newDeck();
        for(int i=0;i<NUMBER_OF_CARDS;i++) {
            cards[i].setButton((Button) view.findViewById(buttonIds[i]));
            cards[i].setAnimation(animations[i]);
        }
    }

    public void newDeck() {
        int counterOfOperation = 4;
        int counterOfNumber = 12;
        duplicationChecker.clear();
        for(int i=0;i<NUMBER_OF_CARDS;i++) {
            if(counterOfOperation != 0 && counterOfNumber != 0) {
                //pick operation or number by random
                if(Util.getRandomInt(2) == PICK_NUMBER) {
                    createNumberCardAt(i);
                    counterOfNumber--;
                } else {
                    createOperatorCardAt(i);
                    counterOfOperation--;
                }
            } else if (counterOfNumber == 0) {
                createOperatorCardAt(i);
            } else {
                createNumberCardAt(i);
            }
        }
    }

    /**
     * Private Helper Functions.
     */

    /**
     *
     * Create a number card at index i
     */
    private void createNumberCardAt(int i) {
        int temp = Util.getRandomInt(20);
        while(isDuplicate("" + temp)) {
            temp = Util.getRandomInt(20);
        }
        cards[i] = new Card(""+((char)('A' + i)), ""+temp);
    }

    /**
     *
     * Create a operator card at index i
     */
    private void createOperatorCardAt(int i) {
        String temp = Util.getRandomOperator();
        while(isDuplicate(temp)) {
            temp = Util.getRandomOperator();
        }
        cards[i] = new Card(""+((char)('A' + i)),temp);
        cards[i].setOperator(true);
    }

    /**
     *
     * @param s check duplication of cards while creating a new deck.
     * @return
     */
    private Boolean isDuplicate(String s) {
        if(duplicationChecker.containsKey(s)) {
            return true;
        } else {
            duplicationChecker.put(s,true);
            return false;
        }
    }

    public Card getCardAt(int index) {
        if(index < 0 || index > 16) {
            throw new IndexOutOfBoundsException();
        }
        return cards[index];
    }

    public int generateTargetNumber() {

        int first = Util.getRandomInt(20);
        int second = Util.getRandomInt(20);
        while(!duplicationChecker.containsKey(""+first)) {
            first =Util.getRandomInt(20);
        }
        while(!duplicationChecker.containsKey(""+second) || second == first) {
            second = Util.getRandomInt(20);
        }

        String operator = Util.getRandomOperator();
        if(operator.equals("*")) {
            return first * second;
        } else if(operator.equals("-")) {
            return first - second;
        } else if(operator.equals("+")) {
            return first + second;
        } else if(operator.equals("/")) {
            return first / second;
        }
        return 0;
    }

    public Card[] getCards() {
        return cards;
    }

}

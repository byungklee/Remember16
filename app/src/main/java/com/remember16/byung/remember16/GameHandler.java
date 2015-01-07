package com.remember16.byung.remember16;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import java.util.Timer;

/**
 * Created by byung on 12/19/14.
 */
//TO DO: create a singleton handler(?) think of some design.

public class GameHandler {
    private static Deck deck;
    private static int counter = 0;
    private static boolean doubleChance = false;
    private static Queue<Card> cardQueue = new LinkedList<>();
    private static int targetNumber = 0;
    private static int score = 0;
    private static AnswerListener al;
    public static boolean init;

    public GameHandler(int[] buttonIds, View view, Animation[] rotations, AnswerListener al) {
        deck = new Deck(buttonIds, view, rotations);
        score = 0;
        GameFragment.score.setText("" + score);
        this.al = al;
        init = true;
    }

    public static void incCounter() {
        counter++;
        if(counter == 3 && !doubleChance) {
            //Verify
            if(verifyAnswer()) {
                score++;
                GameFragment.score.setText("" + score);
                al.execute("Right Answer!");
            } else {
                al.execute("Wrong!");
            }

            while(!cardQueue.isEmpty()) {
                Card card = cardQueue.poll();
                card.flip();
            }
            cardQueue.removeAll(cardQueue); //make sure remove all
            counter = 0;
            targetNumber = deck.generateTargetNumber();
            GameFragment.targetNumber.setText("" + targetNumber);

        }
        //TO DO: implement double chance case
        else if(counter == 5 && !doubleChance) {
//            //Verify
//            while(!cardQueue.isEmpty()) {
//                Card card = cardQueue.pop();
//                card.flip();
//            }
//            cardQueue.removeAllElements();
//            counter = 0;
        }
    }

    private static boolean verifyAnswer() {
        Iterator iterator = cardQueue.iterator();
        Queue<Integer> numberQueue = new LinkedList<Integer>();
        Queue<String> operatorQueue = new LinkedList<String>();
        while(iterator.hasNext()) {
            Card card = (Card) iterator.next();

            if(card.isOperator()) {
                operatorQueue.add(card.getBack());
            } else
                numberQueue.add(Integer.parseInt(card.getBack()));

        }

        if(operatorQueue.size() != 1 && !doubleChance) {
            return false;
        } else if(operatorQueue.size() != 2 && doubleChance) {
            return false;
        }

        int total = 0;
        int counter = 0;

        while(!operatorQueue.isEmpty()) {
            String operator = operatorQueue.poll();
            if(operator.equals("+")) {
                if(counter == 0) {
                    total = total + numberQueue.poll();
                    total += numberQueue.poll();
                } else
                    total = total + numberQueue.poll();

            } else if (operator.equals("-")) {
                if(counter == 0) {
                    total = total + numberQueue.poll() - numberQueue.poll();
                } else
                    total = total - numberQueue.poll();

            } else if (operator.equals("/")) {
                if(counter == 0) {
                    total = total + numberQueue.poll() / numberQueue.poll();
                } else
                    total = total / numberQueue.poll();

            } else if (operator.equals("*")) {
                if(counter == 0) {
                    total = total + numberQueue.poll() * numberQueue.poll();
                } else
                    total = total * numberQueue.poll();
            }
            counter++;
        }

        if(total == targetNumber)
            return true;
        return false;
    }

    public static void addToStack(Card card) {
        cardQueue.add(card);
        incCounter();
    }

    public void flipAll() {
        for(int i=0;i<16;i++) {
            Card card = deck.getCardAt(i);
            card.flip();
        }
    }

    public void generateTargetNumber() {
        targetNumber = deck.generateTargetNumber();
        GameFragment.targetNumber.setText("" + targetNumber);

    }

}

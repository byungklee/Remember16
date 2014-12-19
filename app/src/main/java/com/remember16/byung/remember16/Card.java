package com.remember16.byung.remember16;

import android.widget.Button;

/**
 * Created by byung on 12/19/14.
 */
public class Card {
    private String front;
    private String back;
    private Button button;
    private boolean isFaceUp;

    public Card(String front, String back) {
        this.front = front;
        this.back = back;
        isFaceUp = false;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean isFaceUp) {
        this.isFaceUp = isFaceUp;
    }
}

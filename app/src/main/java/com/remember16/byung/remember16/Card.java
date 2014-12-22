package com.remember16.byung.remember16;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by byung on 12/19/14.
 */
//To do Apply factory method
public class Card {

    private String front;
    private String back;
    private Button button;

    private boolean isFaceUp;
    private Animation animation;
    private Animation.AnimationListener animationListener;

    public Card(String frontString, String backString) {
        this.front = frontString;
        this.back = backString;
        isFaceUp = false;
        animationListener = new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(!isFaceUp) {

                    button.setText(back);
                    button.setBackgroundResource(R.drawable.item_background_selected);
                    setFaceUp(!isFaceUp);
                    GameHandler.addToStack(Card.this);
                } else {
                    button.setText(front);
                    button.setBackgroundResource(R.drawable.item_background);
                    setFaceUp(!isFaceUp);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

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

    public void setButton(Button buttonA) {
        this.button = buttonA;
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isFaceUp) {
                    flip();
                }
            }
        });
        this.button.setText(this.front);
    }

    public void flip() {
      //  animation.setAnimationListener(animationListener);
        button.startAnimation(animation);
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean isFaceUp) {
        this.isFaceUp = isFaceUp;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
        this.animation.setAnimationListener(animationListener);
    }
}

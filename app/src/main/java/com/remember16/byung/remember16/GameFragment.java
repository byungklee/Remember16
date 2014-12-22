package com.remember16.byung.remember16;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment {

    private Animation[] rotations  = new Animation[16];
    private int[] buttonIds = new int[16];
    private GameHandler gameHandler;
    public static TextView targetNumber;
    public static TextView score;
    public static TextView time;
    private CountDownTimer timer;
    private CountDownTimer mainTimer;

    private AnswerListener al = new AnswerListener() {
        @Override
        public void execute(String s) {
            toast(s);
        }
    };

    public static Fragment newInstance() {
        GameFragment fragment = new GameFragment();
        return fragment;
    }

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    private void initButtonIds() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        targetNumber = (TextView) view.findViewById(R.id.target_number);
        score = (TextView) view.findViewById(R.id.my_score);
        time = (TextView) view.findViewById(R.id.time);



        buttonIds[0] = R.id.button1;
        buttonIds[1] = R.id.button2;
        buttonIds[2] = R.id.button3;
        buttonIds[3] = R.id.button4;
        buttonIds[4] = R.id.button5;
        buttonIds[5] = R.id.button6;
        buttonIds[6] = R.id.button7;
        buttonIds[7] = R.id.button8;
        buttonIds[8] = R.id.button9;
        buttonIds[9] = R.id.button10;
        buttonIds[10] = R.id.button11;
        buttonIds[11] = R.id.button12;
        buttonIds[12] = R.id.button13;
        buttonIds[13] = R.id.button14;
        buttonIds[14] = R.id.button15;
        buttonIds[15] = R.id.button16;

        for(int i=0;i<16;i++) {
            rotations[i] = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.to_middle);
        }
        gameHandler = new GameHandler(buttonIds, view, rotations, al);
        gameHandler.flipAll();
        timer = new CountDownTimer(5000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("" + (millisUntilFinished/1000.0D));
            }

            @Override
            public void onFinish() {
                time.setText("" + 0);
                gameHandler.flipAll();
                gameHandler.generateTargetNumber();
                GameHandler.init = false;
                mainTimer.start();
            }
        };
        mainTimer = new CountDownTimer(20000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("" + (millisUntilFinished/1000.0D));
            }

            @Override
            public void onFinish() {
                time.setText("" + 0);
                toast("Game End!");
            }
        };
        timer.start();
        return view;
    }

    public void toast(String s) {
        Toast.makeText(getActivity().getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}

package com.remember16.byung.remember16;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InitialFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InitialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InitialFragment extends Fragment implements Animation.AnimationListener {

    private OnFragmentInteractionListener mListener;

    private Button mStartButton;

    //boolean[][] isFlipped = new boolean[4][4];

    //private boolean isBackOfCardShowing = true;

    // TODO: Rename and change types and number of parameters
    public static InitialFragment newInstance() {
        InitialFragment fragment = new InitialFragment();
        return fragment;
    }

    public InitialFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

    }
    Animation rotation2;
    Animation rotation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_initial, container, false);
        mStartButton = (Button) view.findViewById(R.id.start_button);
//        mStartButton.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                Log.i("Initial", keyCode + " " + event.toString());
//                return false;
//            }
//        });

        mStartButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent arg1) {
                if (arg1.getAction()==MotionEvent.ACTION_DOWN)
                    mStartButton.setBackgroundResource(R.drawable.start_button_clicked);
                else if(arg1.getAction()==MotionEvent.ACTION_HOVER_MOVE) {
                    //mStartButton.setBackgroundResource(R.drawable.start_button2);

                } else if(arg1.getAction()==MotionEvent.ACTION_UP) {
                    mStartButton.setBackgroundResource(R.drawable.start_button2);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.container, GameFragment.newInstance());
                    ft.addToBackStack(null);
                    ft.commit();
                } else {
                    mStartButton.setBackgroundResource(R.drawable.start_button2);
                }
                return true;
            }
        });

//        button2 = (Button) view.findViewById(R.id.button2);
//        rotation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.to_middle);
//        rotation2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.from_middle);
//        rotation.setAnimationListener(this);
//        rotation2.setAnimationListener(this);
//
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!isFlipped[0][1]) {
//                    isFlipped[0][1] = true;
//                    button2.startAnimation(rotation);
//
//
//                } else {
//                    isFlipped[0][1] = false;
//                    button2.setBackgroundResource(R.drawable.red_background);
//                    button2.startAnimation(rotation2);
//                }
//
//            }
//        });




        return view;
    }


//    @Override
//    public void onAnimationEnd(Animation animation) {
//        if (animation==rotation2) {
//
//        } else {
//
//        }
//    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
//        if(animation == rotation) {
//            //button2.startAnimation(rotation2);
//            button2.setBackgroundResource(R.drawable.blue_background);
//            button2.setText("red");
//        } else if(animation == rotation2) {
//
//            //button2.setBackgroundResource(0);
//
//            button2.setText("blue");
//        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}

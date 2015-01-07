package com.remember16.byung.remember16;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameEndDialogFragment extends DialogFragment {

    private Button button;
    private RestartCallback callback;
    public GameEndDialogFragment() {
        // Required empty public constructor
    }

    public static GameEndDialogFragment newInstance(RestartCallback callback) {
        GameEndDialogFragment fragment = new GameEndDialogFragment();
        fragment.setRestartCallback(callback);
        return fragment;
    }
    public void setRestartCallback(RestartCallback callback) {
        this.callback=callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game_end_dialog, container, false);
        getDialog().setTitle("Game Over");

        button = (Button) v.findViewById(R.id.replay_button);
        button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callback.restart();
                    }

                });
        return v;
    }


}

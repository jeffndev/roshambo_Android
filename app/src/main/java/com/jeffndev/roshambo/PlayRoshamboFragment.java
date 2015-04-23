package com.jeffndev.roshambo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by jeffreynewell1 on 4/22/15.
 */
public class PlayRoshamboFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_play_roshambo,container, false);
        ImageButton rockBtn = (ImageButton)rootView.findViewById(R.id.frag_play_roshambo_rock_button);
        ImageButton paperBtn = (ImageButton)rootView.findViewById(R.id.frag_play_roshambo_paper_button);
        ImageButton scissorsBtn = (ImageButton)rootView.findViewById(R.id.frag_play_roshambo_scissors_button);

        //TODO: make ONE listener with a parameter..this is ridiculous...
        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RoshamboResultActivity.class);
                intent.putExtra(RoshamboResultActivity.RPS_CHOICE_KEY, RoshamboResultActivity.ROCK); //TODO: make map structure for this..
                startActivity(intent);
            }
        });
        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RoshamboResultActivity.class);
                intent.putExtra(RoshamboResultActivity.RPS_CHOICE_KEY, RoshamboResultActivity.PAPER); //TODO: make map structure for this..
                startActivity(intent);
            }
        });
        scissorsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RoshamboResultActivity.class);
                intent.putExtra(RoshamboResultActivity.RPS_CHOICE_KEY, RoshamboResultActivity.SCISSORS); //TODO: make map structure for this..
                startActivity(intent);
            }
        });

        return rootView;
    }
}

package com.jeffndev.roshambo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by jeffreynewell1 on 4/22/15.
 */
public class RoshamboResultFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int rps = RoshamboResultActivity.ROCK;
        Bundle args = getArguments();
        if(args != null){
            rps = args.getInt(RoshamboResultActivity.RPS_CHOICE_KEY);
        }
        Random rnd = new Random(System.currentTimeMillis());
        int dealerRps = 1 + rnd.nextInt(3); // random 1-3

        View rootView = inflater.inflate(R.layout.fragment_roshambo_result,container,false);
        ImageView imgStatus = (ImageView)rootView.findViewById(R.id.frag_result_status_imageview);
        TextView txtStatus = (TextView)rootView.findViewById(R.id.frag_result_status_textview);
        Button btnPlayAgain = (Button)rootView.findViewById(R.id.frag_result_playagain_button);

        imgStatus.setImageResource(R.drawable.rock_crushes_scissors); //TODO: has to depend on choices..
        txtStatus.setText("Rock crushes scissors, I win!");//TODO: put these strings as format strings in the string resources..

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return rootView;
    }
}

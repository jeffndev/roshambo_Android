package com.jeffndev.roshambo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by jeffreynewell1 on 4/22/15.
 */
public class RoshamboResultFragment extends Fragment{
    private final String LOG_TAG = RoshamboResultFragment.class.getSimpleName();

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

        setGameStatusVisuals(rps, dealerRps, txtStatus, imgStatus);

        return rootView;
    }
    private void setGameStatusVisuals(int playerRps, int dealerRps,
                                      TextView statusLbl, ImageView statusImg){
        Log.v(LOG_TAG,"player: " + playerRps + "\tdealer: " + dealerRps);
        //TODO: put these strings as format strings in the string resources..
        if(playerRps == dealerRps) {
            statusLbl.setText(getString(R.string.status_text_tie));
            statusImg.setImageResource(R.drawable.its_a_tie);
            return;
        }
        int[] rpsChoices = {playerRps, dealerRps};
        Arrays.sort(rpsChoices);
        if(rpsChoices[0] == RoshamboResultActivity.ROCK && rpsChoices[1] == RoshamboResultActivity.PAPER){
            //rock/paper
            statusLbl.setText("Paper covers rock, " + (playerRps == RoshamboResultActivity.PAPER ? "you" : "I" ) + " win!");
            statusImg.setImageResource(R.drawable.paper_covers_rock);
        }else if(rpsChoices[0] == RoshamboResultActivity.ROCK){
            //rock/scissors
            statusLbl.setText("Rock crushes scissors, " + (playerRps == RoshamboResultActivity.ROCK ? "you" : "I" ) + " win!");
            statusImg.setImageResource(R.drawable.rock_crushes_scissors);
        }else{
            //paper/scissors
            statusLbl.setText("Scissors cut paper, " + (playerRps == RoshamboResultActivity.SCISSORS ? "you" : "I" ) + " win!");
            statusImg.setImageResource(R.drawable.scissors_cut_paper);
        }
    }
}

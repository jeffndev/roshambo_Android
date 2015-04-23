package com.jeffndev.roshambo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by jeffreynewell1 on 4/22/15.
 */
public class RoshamboResultActivity extends ActionBarActivity {
    public static final String RPS_CHOICE_KEY = "rps";
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roshambo_result);
        if(savedInstanceState == null){
            int rps = getIntent().getIntExtra(RPS_CHOICE_KEY, ROCK);
            RoshamboResultFragment resultFragment = new RoshamboResultFragment();
            Bundle args = new Bundle();
            args.putInt( RPS_CHOICE_KEY, rps);
            resultFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_roshambo_result, resultFragment)
                    .commit();
        }
    }
}

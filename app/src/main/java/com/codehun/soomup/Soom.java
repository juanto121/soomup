package com.codehun.soomup;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.skyfishjy.library.RippleBackground;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Soom extends Activity implements AnswerFragment.AnswerListSelectionListener {

    private static String TAG = "SoomActivity";
    private final Handler handle = new Handler();
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    private RippleBackground ripple_back;
    private Game game;
    private FragmentManager fragments;
    private AnswerFragment answers;
    private QuestionFragment question;
    private Problem current_problem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        game = new SumGame();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soom);

        ripple_back =  (RippleBackground) findViewById(R.id.ripple_background);
        fragments = getFragmentManager();

        answers = (AnswerFragment) fragments.findFragmentById(R.id.answer_fragment);
        question= (QuestionFragment) fragments.findFragmentById(R.id.problem_fragment);

        showNextProblem();


    }

    private void showNextProblem(){
        current_problem = game.nextProblem();
        question.showProblemQuestion(current_problem);
        answers.setAnswers(current_problem.getAnswers());
    }


    @Override
    public void onAnswerSelection(int index) {
        Log.d(TAG, "Item selected in answer list view");
        ripple_back.startRippleAnimation();
        //TODO Check if this way of handling the dalayed call is the best for the UI.

        handle.postDelayed(new Runnable(){
            @Override
        public void run(){
                ripple_back.stopRippleAnimation();
            }
        },700);
        if( game.checkUserAnswer( Integer.parseInt(current_problem.getAnswers()[index]) ) ){

        }else{
            YoYo.with(Techniques.Wobble).duration(200).playOn(findViewById(R.id.problem_view));
        }
       showNextProblem();
    }

    private void cancelRipple(){
        Runnable call_ripple_stop = new Runnable() {
            @Override
            public void run() {
                ripple_back.stopRippleAnimation();
                Log.d(TAG, "Stopping Ripple Effect");
            }
        };

    }




    public Game getGame(){
        return this.game;
    }
}

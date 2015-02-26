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

import com.skyfishjy.library.RippleBackground;

import java.util.Timer;
import java.util.TimerTask;


public class Soom extends Activity implements AnswerFragment.AnswerListSelectionListener {

    private static String TAG = "SoomActivity";
    private RippleBackground ripple_back;
    private Game game;
    private FragmentManager fragments;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        game = new SumGame();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soom);

        ripple_back =  (RippleBackground) findViewById(R.id.content);
        fragments = getFragmentManager();

        AnswerFragment answers = (AnswerFragment) fragments.findFragmentById(R.id.answer_fragment);
        QuestionFragment question = (QuestionFragment) fragments.findFragmentById(R.id.problem_fragment);

        Problem current_problem = game.nextProblem();

        question.showProblemQuestion(current_problem);
        answers.setAnswers(current_problem.getAnswers());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_soom, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
        }

    @Override
    public void onAnswerSelection(int index) {
        Log.d(TAG, "Item selected in answer list view");
        ripple_back.startRippleAnimation();
    }

    public Game getGame(){
        return this.game;
    }
}

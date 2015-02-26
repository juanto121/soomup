package com.codehun.soomup;

/**
 * Created by Juanto on 2/25/2015.
 */
public class SumGame implements Game {
    private static int SINGLE_DIGIT_LEVEL = 1;
    private static int MAX_HEALTH = 2;

    private static int max_correct_answers;

    private SumProblem current_problem;
    private int lives;
    private int level;
    private int current_correct_answers;
    private int previous_max_correct_answers;


    public SumGame(){
        current_problem = new SumProblem();
        lives = MAX_HEALTH;
        level = SINGLE_DIGIT_LEVEL;
        current_correct_answers = 0;
        previous_max_correct_answers = 0;
        max_correct_answers = 0;
    }

    @Override
    public SumProblem nextProblem(){
        current_problem = new SumProblem();
        return current_problem;
    }

    public void checkUserAnswer(int user_answer){
        if(user_answer != current_problem.getRealAnswer()){
            lives--;
        }else{
            current_correct_answers++;
        }
    }

    public Problem getCurrentProblem(){
        return this.current_problem;
    }
}

package com.codehun.soomup;

/**
 * Created by Juanto on 2/25/2015.
 */
public class SumProblem implements Problem {

    private static int SINGLE_DIGIT = 1;
    private static int ANSWERS_TO_SHOW = 3;

    private Sum sum;
    private String[] answers;
    private int level;
    private int realAnswer;

    public SumProblem(){
        sum = new Sum();
        answers = new String[ANSWERS_TO_SHOW];
        level = SINGLE_DIGIT;
        calculate_answers();
    }

    public SumProblem(int user_level){
        sum = new Sum(user_level);
        answers = new String[ANSWERS_TO_SHOW];
        level = user_level;
    }

    private void calculate_answers(){
        int real_answer = sum.getResult();
        int low_limit = real_answer - ANSWERS_TO_SHOW / 2;

        for(int result = low_limit, index = 0; index < ANSWERS_TO_SHOW; result++, index ++){
            answers[index] = result+"";
        }
    }

    @Override
    public String toString(){
        return sum.getA() + " + " + sum.getB();
    }

    public void setLevel(int new_level){
        level = new_level;
    }

    public int getRealAnswer() {
        return this.sum.getResult();
    }


    @Override
    public String[] getAnswers() {
        return answers;
    }

    public String getQuestion(){
        return toString();
    }
}

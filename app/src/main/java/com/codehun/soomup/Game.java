package com.codehun.soomup;

/**
 * Created by Juanto on 2/25/2015.
 */
public interface Game {
    public Problem nextProblem();
    public boolean checkUserAnswer(int answer);
}

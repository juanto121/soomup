package com.codehun.soomup;

/**
 * Created by Juanto on 2/25/2015.
 */
public class Sum {

    private int a;
    private int b;
    private int result;
    private int number_of_digits;

    public Sum(){
        number_of_digits = 1;
        a = generate_int_with_digits(number_of_digits);
        b = generate_int_with_digits(number_of_digits);
        result = a + b;
    }

    public Sum(int digits){
        number_of_digits = digits;
        a = generate_int_with_digits(number_of_digits);
        b = generate_int_with_digits(number_of_digits);
        result = a + b;
    }

    private int generate_int_with_digits(int digits){
        return (int)(Math.random() * Math.pow(10,digits));
    }


    public int getResult() {
        return result;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

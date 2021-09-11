package com.hungdoan.algorithm.recursion;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int number = 6;
        int result = fibonacci.calculate(number);
        System.out.println(result);
    }

    public int calculate(int number) {
        if (number == 0 || number == 1) {
            return number;
        }
        return calculate(number - 1) + calculate(number - 2);
    }
}

package com.ery.algorithms;

public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(123));
    }
    public static int numberOfSteps (int num) {
        int count = 0;
        while(num > 0){
            count++;
            if (num % 2 == 0){
                num = num / 2;
                continue;
            }else{
                num--;
            }
        }

        return count;
    }
}

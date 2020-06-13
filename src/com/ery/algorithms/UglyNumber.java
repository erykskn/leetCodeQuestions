package com.ery.algorithms;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(6));
    }

    public boolean isUgly(int num) {

        while(num > 0)
        {
            if(num%2==0) { num=num/2; continue;}
            if(num%3==0) { num=num/3; continue;}
            if(num%5==0) { num=num/5; continue;}

            if (num == 1)  return true;
            else return false;
        }

        return false;
    }
}

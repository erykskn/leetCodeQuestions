package com.ery.algorithms;

import java.util.*;

public class KidsWiththeGreatestNumberofCandies {

    public static void main(String[] args) {
        int[] a = {2,3,5,1,3};
        System.out.println(kidsWithCandies(a, 3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> booleans = new ArrayList<>();
        int[] temp = candies.clone();
        Arrays.sort(temp);
        int maxNumberInCandies = temp[candies.length - 1];


        for(int index = 0; index < candies.length; index++){
            if (candies[index] + extraCandies >= maxNumberInCandies){
                booleans.add(true);
            }else{
                booleans.add(false);
            }
        }

        return booleans;
    }
}

package com.ery.algorithms;

import java.util.*;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {5, 2, 2,1,2,2,3,6,5,7,8,5,7};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        int result = 0;
        SortedMap<Integer, Integer> integerIntegerMap = new TreeMap<>(Collections.reverseOrder());
        for (int a : nums) {
            integerIntegerMap.put(a, a);
        }

        if (integerIntegerMap.size() < 3) {
            result = integerIntegerMap.get(integerIntegerMap.firstKey());
        } else {
            int count = 3;
            for (Map.Entry<Integer, Integer> entry : integerIntegerMap.entrySet()) {
                count--;
                if (count == 0) {
                    result = entry.getValue();
                    break;
                }
            }

        }


        return result;
    }
}

package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(isAnagram("ac", "bb"));
    }

    // https://leetcode.com/problems/valid-anagram/
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int UNICODE_LENGTH = 512;
        int[] res = new int[UNICODE_LENGTH]; // 256 for ascii, 512 for unicode
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i)]++;
            res[t.charAt(i)]--;
        }
        for (int i = 0; i < UNICODE_LENGTH; i++) {
            if(res[i] != 0){
                return false;
            }
        }
        return true;
    }

    // https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
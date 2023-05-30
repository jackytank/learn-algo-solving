package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Arrays.stream(plusOne(new int[]{9, 9, 9, 9, 9, 9})).forEach(n -> System.out.println(n));
    }

    // https://leetcode.com/problems/plus-one/
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    // https://leetcode.com/problems/longest-common-prefix/
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String curStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < curStr.length(); j++) {
                if (strs[i].length() == 0) {
                    curStr = "";
                    break;
                }
                if (curStr.charAt(j) != strs[i].charAt(j)) {
                    curStr = curStr.substring(0, j);
                    break;
                }
                if (j == strs[i].length() - 1) {
                    curStr = curStr.substring(0, j + 1);
                    break;
                }
            }
        }
        return curStr;
    }

    // https://leetcode.com/problems/contains-duplicate/
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        if (nums.length == 2 && nums[0] != nums[1]) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return nums.length != set.size();
    }

    // https://leetcode.com/problems/missing-number/
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int sumExpect = 0;
        boolean existNum_0 = false;
        for (int i = 0; i < nums.length; i++) {
            sumExpect += i + 1;
            sum += nums[i];
            if (nums[i] == 0) existNum_0 = true;
        }
        if (!existNum_0) return 0;
        return sumExpect - sum;
    }

    // https://leetcode.com/problems/binary-search/
    public static int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    // https://leetcode.com/problems/length-of-last-word/
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }

    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
    public int strStr(String haystack, String needle) {
        char firstCharNeedle = needle.charAt(0);
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            int count = 0;
            if (i + needle.length() > haystack.length()) return -1;
            if (haystack.charAt(i) == firstCharNeedle) {
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) == needle.charAt(j)) {
                        count++;
                    }
                }
                if (count == needle.length() - 1) return i;
            }
        }
        return -1;
    }

    // https://leetcode.com/problems/valid-parentheses/
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.size() >= 1) {
                char last = (char) stack.lastElement();
                if ((cur == last + 1) || (cur == last + 2)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(cur);
        }
        return stack.isEmpty();
    }

    // https://leetcode.com/problems/roman-to-integer/
    public int romanToInt(String s) {
        if (s.length() < 1 || s.length() > 15) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i++;
                    continue;
                }
                if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i++;
                    continue;
                }
                res += 1;
            }
            if (s.charAt(i) == 'V') res += 5;
            if (s.charAt(i) == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i++;
                    continue;
                }
                if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i++;
                    continue;
                }
                res += 10;
            }
            if (s.charAt(i) == 'L') res += 50;
            if (s.charAt(i) == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    res += 400;
                    i++;
                    continue;
                }
                if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    res += 900;
                    i++;
                    continue;
                }
                res += 100;
            }
            if (s.charAt(i) == 'D') res += 500;
            if (s.charAt(i) == 'M') res += 1000;
        }
        return res;
    }

    // https://leetcode.com/problems/group-anagrams/
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            if (strs[0].isEmpty()) {
                return Arrays.asList(Arrays.asList(""));
            }
            return Arrays.asList(Arrays.asList(strs[0]));
        }
        Map<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (map.containsKey(sortedStr) == true) {
                map.get(sortedStr).add(strs[i]);
            }
            if (map.containsKey(sortedStr) == false) {
                ArrayList<String> groupList = new ArrayList<>();
                groupList.add(strs[i]);
                map.put(sortedStr, groupList);
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    // https://leetcode.com/problems/valid-anagram/
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int UNICODE_LENGTH = 512;
        int[] res = new int[UNICODE_LENGTH]; // 256 for ascii, 512 for unicode
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i)]++;
            res[t.charAt(i)]--;
        }
        for (int i = 0; i < UNICODE_LENGTH; i++) {
            if (res[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
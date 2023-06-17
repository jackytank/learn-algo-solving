package org.example;

import java.util.*;

public class Algo {
    public static void main(String[] args) {
        // Arrays.stream(plusOne(new int[]{9, 9, 9, 9, 9, 9})).forEach(n ->
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
    }

    // https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
    public static int maxArea(int[] height) {
        return 0;
    }

    // https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150
    public static List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == target) {
                    var triplet = Arrays.asList(nums[i], nums[l], nums[r]);
                    if (!seen.contains(triplet)) {
                        res.add(triplet);
                        seen.add(triplet);
                    }
                    ++l;
                    --r;
                } else if (sum < 0) {
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return res;
    }

    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
    public static int[] twoSumSortedArray(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] res = new int[2];
        int sum = 0;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    // https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
    public static boolean isIsomorphic(String s, String t) {
        var map1 = new int[127];
        var map2 = new int[127];
        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    // https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        var stack = new Stack<Character>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == t.charAt(i)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    // https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int minTime = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                map.put(nums[i], val + 1);
                if (val + 1 > minTime) return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public static int maxProfit(int[] prices) {
        int least = Integer.MAX_VALUE;
        int overralProfit = 0;
        int profitSoldToday = 0;
        for (int i = 0; i < prices.length; i++) {
            if (least > prices[i]) {
                least = prices[i];
            }
            profitSoldToday = prices[i] - least;
            if (overralProfit < profitSoldToday) {
                overralProfit = profitSoldToday;
            }
        }
        return overralProfit;
    }

    // https://leetcode.com/problems/detect-capital/
    public static boolean detectCapitalUse(String word) {
        String lowerStr = word.toLowerCase();
        boolean allAreNot = lowerStr.equals(word);
        boolean allAre = word.toUpperCase().equals(word);
        boolean onlyFirst = Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(lowerStr.substring(1));
        return allAreNot || allAre || onlyFirst;
    }

    // https://leetcode.com/problems/longest-palindrome/
    public static int longestPalindrome(String s) {
        if (s.length() == 2 && (s.charAt(0) == s.charAt(1))) return 2;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), i);
            }
        }
        int res = s.length() - map.size();
        if (s.length() == res) return res;
        return res % 2 == 0 ? res + 1 : res;
    }

    // https://leetcode.com/problems/valid-palindrome/
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) return false;
        String str = s.chars().filter(Character::isLetterOrDigit).mapToObj(x -> Character.toLowerCase((char) x)).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) == str.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
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
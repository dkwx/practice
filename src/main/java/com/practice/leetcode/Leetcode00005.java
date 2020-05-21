package com.practice.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00005 {


    class Solution {

        /**
         * 暴力法
         */
        public String longestPalindrome3(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                int length1 = expand(s, i, i + 1);
                int length2 = expand(s, i, i);
                int maxLen = Math.max(length1, length2);
                if (maxLen > (end - start)) {
                    start = i - (maxLen - 1) / 2;
                    end = i + maxLen / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expand(String s, int start, int end) {
            int length = 1;
            if (start != end) {
                if (s.charAt(start) == s.charAt(end)) {
                    length++;
                } else {
                    return length;
                }
            }
            while (start > 0 && end < (s.length() - 1)) {
                if (s.charAt(start - 1) == s.charAt(end + 1)) {
                    length += 2;
                    start--;
                    end++;
                } else {
                    break;
                }
            }
            return length;
        }

        /**
         * 暴力法
         */
        public String longestPalindrome(String s) {
            int length = s.length();
            String maxStr = "";
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < (length - i); j++) {
                    String subStr = s.substring(i, length - j);
                    boolean flag = isRight(subStr);
                    if (flag && subStr.length() > maxStr.length()) {
                        maxStr = subStr;
                    }

                }
            }
            return maxStr;
        }

        /**
         * 回文法
         */
        public String longestPalindrome2(String s) {
            if (s.isEmpty()) {
                return s;
            }
            String reverse = new StringBuilder(s).reverse().toString();
            String origin = s;
            int maxLength = 0;
            int end = 0;
            int length = s.length();
            int[][] arrs = new int[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (origin.charAt(i) == reverse.charAt(j)) {
                        if (i > 0 && j > 0) {
                            arrs[i][j] = arrs[i - 1][j - 1] + 1;
                        } else {
                            arrs[i][j] = 1;
                        }

                        if (arrs[i][j] > maxLength) {
                            if (i == (length - j - 1 - 1 + arrs[i][j])) {
                                maxLength = arrs[i][j];
                                end = i;
                            }
                        }
                    } else {
                        arrs[i][j] = 0;
                    }
                }
            }
            return s.substring(end - maxLength + 1, end + 1);
        }

        public boolean isRight(String str) {
            int length = str.length();
            for (int i = 0; i < length / 2; i++) {
                if (str.charAt(i) != str.charAt(length - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00005().new Solution();
        System.out.println(solution.longestPalindrome3("babad"));
    }
}

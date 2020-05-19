package com.practice.leetcode;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00680 {


    class Solution {
        public boolean validPalindrome(String s) {
            // 错误解法，有可能两边任意一边删除一个字符，就可以匹配
            // char[] chars = s.toCharArray();
            // int start = 0, end = chars.length - 1;
            // int count = 0;
            // while (start < end) {
            //     if (chars[start] == chars[end]) {
            //         start++;
            //         end--;
            //     } else if (count < 1) {
            //         if (chars[start + 1] == chars[end]) {
            //             start++;
            //         } else if (chars[start] == chars[end-1]) {
            //             end--;
            //         } else {
            //             return false;
            //         }
            //         count++;
            //     } else {
            //         return false;
            //     }
            // }
            // return true;
            return find(s, 0, s.length() - 1, 1);
        }

        private boolean find(String s, int start, int end, int chance) {
            if (start > end) {
                return true;
            }
            if (s.charAt(start) == s.charAt(end)) {
                return find(s, start + 1, end - 1, chance);
            } else if (chance > 0) {
                return find(s, start + 1, end, chance - 1) || find(s, start, end - 1, chance - 1);
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00680().new Solution();
        System.out.println(solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}

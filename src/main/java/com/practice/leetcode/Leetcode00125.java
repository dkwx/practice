package com.practice.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00125 {


    class Solution {
        public boolean isPalindrome(String s) {

            int constDistance = 'a' - 'A';
            s = s.trim();
            if (s.isEmpty()) {
                return true;
            }
            int start = 0, end = s.length() - 1;
            while (start <= end) {
                char cs = s.charAt(start);
                if (!isABC(cs) && !isNumber(cs)) {
                    start++;
                    continue;
                }
                char ce = s.charAt(end);
                if (!isABC(ce) && !isNumber(ce)) {
                    end--;
                    continue;
                }
                if (cs != ce) {
                    if (isABC(cs) && isABC(ce)) {
                        int distance = Math.abs(cs - ce);
                        if (distance != 0 && distance != constDistance) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                start++;
                end--;
            }
            return true;
        }

        private boolean isABC(char charAt) {
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        private boolean isNumber(char charAt) {
            return charAt >= '0' && charAt <= '9';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00125().new Solution();
        System.out.println(solution.isPalindrome("race a car"));
    }
}

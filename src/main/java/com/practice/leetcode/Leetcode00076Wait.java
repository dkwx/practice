package com.practice.leetcode;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00076Wait {


    class Solution {
        public String minWindow(String s, String t) {
            if (t.length() == 1 && s.contains(t)) {
                return t;
            }
            Set<Character> characterSet = t.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

            int start = 0, end = 0, minLength = Integer.MAX_VALUE, minEnd = 0;
            boolean afterMove = true;
            while (start <= end && end < s.length()) {
                if (afterMove && !characterSet.contains(s.charAt(end))) {
                    end++;
                    continue;
                }
                if (!afterMove && !characterSet.contains(s.charAt(start))) {
                    start++;
                    continue;
                }
                if (containsAllChar(s.substring(start, end + 1), t)) {
                    int currLength = end - start + 1;
                    if (currLength < minLength) {
                        minLength = currLength;
                        minEnd = end;
                    }
                    start++;
                    afterMove = false;
                } else {
                    end++;
                    afterMove = true;
                }
            }
            if (minLength == Integer.MAX_VALUE) {
                return "";
            }
            return s.substring(minEnd - minLength + 1, minEnd + 1);
        }

        private boolean containsAllChar(String substring, String t) {
            if (substring.length() < t.length()) {
                return false;
            }
            List<Character> list = substring.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            for (char c : t.toCharArray()) {
                if (!list.contains(c)) {
                    return false;
                }
                list.remove(Character.valueOf(c));
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00076Wait().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}

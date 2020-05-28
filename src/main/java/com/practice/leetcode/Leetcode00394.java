package com.practice.leetcode;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00394 {
    Stack<Character> stack = new Stack<>();

    class Solution {
        public String decodeString(String s) {
            return repeat(s);
        }

        private String repeat(String s) {
            for (char ch : s.toCharArray()) {
                if (ch != ']') {
                    stack.push(ch);
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (stack.peek() != '[') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    StringBuilder numberBuilder = new StringBuilder();
                    while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                        numberBuilder.append(stack.pop());
                    }
                    int number = Integer.valueOf(numberBuilder.reverse().toString());
                    for (int i = 0; i < number; i++) {

                        for (int local = sb.length() - 1; local >= 0; local--) {
                            stack.push(sb.charAt(local));
                        }
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            return result.reverse().toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00394().new Solution();
        System.out.println(solution.decodeString("100[leetcode]"));
    }
}

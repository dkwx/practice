package com.practice.leetcode;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00067 {


    class Solution {
        public String addBinary(String a, String b) {
            boolean upOne = false;
            if (a.length() < b.length()) {
                String temp = a;
                a = b;
                b = temp;
            }
            a = new StringBuilder(a).reverse().toString();
            b = new StringBuilder(b).reverse().toString();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                int left = Integer.valueOf(a.charAt(i) + "");
                int right;
                if (i > (b.length() - 1)) {
                    right = 0;
                } else {
                    right = Integer.valueOf(b.charAt(i) + "");
                }
                int sum;
                if (upOne) {
                    sum = left + right + 1;
                } else {
                    sum = left + right;
                }
                if (sum > 1) {
                    upOne = true;
                    sum = sum % 2;
                } else {
                    upOne = false;
                }
                sb.append(sum);
            }
            if (upOne) {
                sb.append(1);
            }
            return sb.reverse().toString();

        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00067().new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
    }
}

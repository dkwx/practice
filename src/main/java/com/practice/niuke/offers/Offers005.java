package com.practice.niuke.offers;

/**
 * 剑指offer
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers005 {
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (ch == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
            // return s.replaceAll(" ", "%20");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Offers005().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }
}

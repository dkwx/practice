package com.practice.leetcode.offers;

/**
 * 剑指offer
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers058_2 {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            StringBuilder sb = new StringBuilder(s.substring(n));
            sb.append(s.substring(0, n));
            // for (int i = 0; i < n; i++) {
            //     sb.append(s.charAt(i));
            // }
            return sb.toString();

        }
    }

    public static void main(String[] args) {
        Offers058_2 offers = new Offers058_2();
        System.out.println(offers.new Solution().reverseLeftWords("dd", 2));
    }
}
